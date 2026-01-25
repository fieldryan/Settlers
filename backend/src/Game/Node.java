package Game;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbours = new ArrayList<>();

    List<Road> roadsFrom = new ArrayList<>();
    List<Road> roadsTo = new ArrayList<>();

    Building building = null;

    public Node(Node neigh0, Node neigh1, Node neigh2) {
        neighbours.add(neigh0);
        neighbours.add(neigh1);
        neighbours.add(neigh2);
    }

    public void addRoadFrom(Node fromNode){
        Road fromRoad = new Road(fromNode, this);
        if(!neighbours.contains(fromNode) || roadsFrom.contains(fromRoad)) return;
        roadsFrom.add(fromRoad);
        addRoadTo(fromNode);
    }

    public void addRoadTo(Node toNode){
        Road roadTo = new Road(this, toNode);
        if(!neighbours.contains(toNode) || roadsTo.contains(roadTo)) return;
        roadsTo.add(roadTo);
        addRoadFrom(toNode);
        toNode.addRoadFrom(this);
    }

    public void addBuilding(Building building){
        this.building = building;
    }

}
