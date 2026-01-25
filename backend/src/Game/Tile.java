package Game;

public class Tile {

    public final TileType tileType;
    public final TilePos pos;
    public final int diceNumber;

    public Tile(TileType tileType, TilePos pos, int diceNumber) {
        this.tileType = tileType;
        this.pos = pos;
        this.diceNumber = diceNumber;
    }

}
