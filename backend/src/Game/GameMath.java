package Game;

public class GameMath {
    private GameMath(){}

    /**
     * Clockwise directions for the nodes
     */
    public static final Direction[] directions = {
            Direction.E,
            Direction.NE,
            Direction.NW,
            Direction.W,
            Direction.SW,
            Direction.SE
    };

    public static NodePos nodeOf(TilePos center, int i){
        TilePos a = directions[i].d;
        TilePos b = directions[(i + 1) % 6].d;
        TilePos c = center.mul(3);
        return new NodePos(
                c.q() + a.q() + b.q(),
                c.r() + a.r() + b.r(),
                c.s() +  a.s() + b.s()
        );
    }

}
