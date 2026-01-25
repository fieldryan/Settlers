package Game;

public enum Direction {
    E ( 1,-1, 0),
    NE( 1, 0,-1),
    NW( 0, 1,-1),
    W (-1, 1, 0),
    SW(-1, 0, 1),
    SE( 0,-1, 1);

    public final TilePos d;
    Direction(int q, int r, int s) { this.d = new TilePos(q,r,s); }
}
