package Game;

/**
 * In a hexagonigal grid there are 3 dimensions instead of 2.
 * q,r,s. q for NorthWest. r for East. s for SouthWest. (not accurate, but the side in that direction.
 */
public record TilePos(int q, int r, int s) {
    public TilePos{if(q+r+s != 0) throw new IllegalArgumentException();}
    public TilePos add(TilePos pos){return new TilePos(q + pos.q, r + pos.r, s + pos.s);}
    public TilePos mul(int k){return new TilePos(q * k, r * k, s * k);}
}
