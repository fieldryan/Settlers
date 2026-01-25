package Game;

/**
 * In a hexagonigal grid there are 3 dimensions instead of 2.
 * q,r,s. q for NorthWest. r for East. s for SouthWest. (not accurate, but the side in that direction.
 */
public record TilePos(int q, int r, int s) {
}
