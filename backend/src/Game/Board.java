package Game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Tile[][][] tileBoard = new Tile[5][5][5];
    private final List<TileType> tiles = new ArrayList<>();
    private final List<Integer> counters = new ArrayList<>(List.of(2,3,3,4,4,5,5,6,6,8,8,9,9,10,10,11,11,12));


    static final TilePos[] DIR = new TilePos[] {
            new TilePos( 1, -1,  0),
            new TilePos( 1,  0, -1),
            new TilePos( 0,  1, -1),
            new TilePos(-1,  1,  0),
            new TilePos(-1,  0,  1),
            new TilePos( 0, -1,  1)
    };
    
    
    public Board(int sheepTileCount, int wheatTileCount, int stoneTileCount, int woodTileCount, int brickTileCount) {
        int boardSize = 18;
        assert sheepTileCount + wheatTileCount + stoneTileCount + woodTileCount == boardSize;
        for(int i = 0; i < sheepTileCount; i++) tiles.add(TileType.SHEEP);
        for(int i = 0; i < wheatTileCount; i++) tiles.add(TileType.WHEAT);
        for(int i = 0; i < stoneTileCount; i++) tiles.add(TileType.STONE);
        for(int i = 0; i < woodTileCount; i++) tiles.add(TileType.WOOD);
        for(int i = 0; i < brickTileCount; i++) tiles.add(TileType.BRICK);
        tiles.add(TileType.DESERT);
        createBoard();
    }

    public void createBoard() {
        for (int q = 0; q < 5; q++) {
            for (int r = 0; r < 5; r++) {
                for (int s = 0; s < 5; s++) {
                    tileBoard[q][r][s] = getRandomTile(q, r, s);
                }
            }
        }
    }

    private int getRandomDiceNumber(){
        return counters.remove((int) (Math.random() * counters.size()));
    }

    private Tile getRandomTile(int q, int r, int s) {
        return new Tile(tiles.remove((int) (Math.random() * tiles.size())), new TilePos(q,r,s), getRandomDiceNumber());
    }

    public Tile[][][] getTileBoard(){
        return tileBoard;
    }

    
    


}

