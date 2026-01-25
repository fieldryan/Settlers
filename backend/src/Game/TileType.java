package Game;

public enum TileType {
    BRICK(ResourceType.BRICK),
    WHEAT(ResourceType.WHEAT),
    WOOD(ResourceType.WOOD),
    STONE(ResourceType.STONE),
    SHEEP(ResourceType.SHEEP),
    DESERT(null),
    OCEAN(null);


    private final ResourceType resource;
    TileType(ResourceType resource) {
        this.resource = resource;
    }
    ResourceType getResource() {return resource;}
}
