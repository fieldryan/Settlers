package Game;

public record NodePos(int q, int r, int s) implements Comparable<NodePos> {
    public NodePos {if(q + r + s!= 0) throw new IllegalArgumentException();}

    @Override
    public int compareTo(NodePos o) {
        if(q != o.q()) return Integer.compare(q, o.q);
        if(r != o.r) return Integer.compare(r, o.r);
        return  Integer.compare(s, o.s);
    }
}
