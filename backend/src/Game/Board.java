package Game;


import java.util.*;

public class Board {
    Map<NodePos, Node> nodes = new HashMap<>();
    Map<TilePos, Tile> tileMap = new HashMap<>();

    private final List<TileType> tilesToAdd = new ArrayList<>();
    private final List<Integer> counters = new ArrayList<>(List.of(2,3,3,4,4,5,5,6,6,8,8,9,9,10,10,11,11,12));


    public Board(int sheepTileCount, int wheatTileCount, int stoneTileCount, int woodTileCount, int brickTileCount) {
        int boardSize = 18;
        assert sheepTileCount + wheatTileCount + stoneTileCount + woodTileCount + brickTileCount == boardSize;
        for(int i = 0; i < sheepTileCount; i++) tilesToAdd.add(TileType.SHEEP);
        for(int i = 0; i < wheatTileCount; i++) tilesToAdd.add(TileType.WHEAT);
        for(int i = 0; i < stoneTileCount; i++) tilesToAdd.add(TileType.STONE);
        for(int i = 0; i < woodTileCount; i++) tilesToAdd.add(TileType.WOOD);
        for(int i = 0; i < brickTileCount; i++) tilesToAdd.add(TileType.BRICK);
        tilesToAdd.add(TileType.DESERT);
        createBoard();
    }

    public void createBoard() {
        int radius = 2;
        for (int q = -radius; q <= radius; q++) {
            int rMin = Math.max(-radius, -q - radius);
            int rMax = Math.min(radius, -q + radius);
            for (int r = rMin; r <= rMax; r++) {
                int s = -q - r;
                tileMap.put(new TilePos(q,r,s), getRandomTile(q, r, s));
            }
        }


        buildNodes();
    }

    private void buildNodes() {
        for(Tile tile: tileMap.values()){
            for(int i = 0; i < 6; i++){
                NodePos pos = GameMath.nodeOf(tile.pos, i);
                nodes.computeIfAbsent(pos,Node::new);
            }
        }
    }

    private Tile getRandomTile(int q, int r, int s) {
        TileType type = tilesToAdd.remove((int) (Math.random() * tilesToAdd.size()));
        if(type.equals(TileType.DESERT)) return new Tile(type, new TilePos(q,r,s));
        return new Tile(type, new TilePos(q,r,s));
    }

    public Map<TilePos, Tile> getTileBoard(){
        return tileMap;
    }

    
    


}

