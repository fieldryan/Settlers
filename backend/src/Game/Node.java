package Game;

public class Node {
    public final NodePos pos;
    private Building building = null;



    public Node(NodePos pos) {
        this.pos = pos;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
