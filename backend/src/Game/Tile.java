package Game;

public class Tile {

    public final TileType tileType;
    public final TilePos pos;
    public int diceNumber = 0;

    public Tile(TileType tileType, TilePos pos) {
        this.tileType = tileType;
        this.pos = pos;
    }

    public void setDiceNumber(Integer number){
        this.diceNumber = number;
    }

}
