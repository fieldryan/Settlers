package Game;

import java.util.*;

public class Bank {
    private List<DevelopmentCard> developmentCards = new ArrayList<>();
    private Map<ResourceType, Integer> resourceCards = new HashMap<>();

    public Bank(){
        populateResourceCards();
        populateDevelopmentCards();
    }


    private void populateResourceCards(){
        resourceCards.put(ResourceType.WHEAT, 19);
        resourceCards.put(ResourceType.STONE, 19);
        resourceCards.put(ResourceType.WOOD, 19);
        resourceCards.put(ResourceType.BRICK, 19);
        resourceCards.put(ResourceType.SHEEP, 19);
    }

    private void populateDevelopmentCards(){
        for(int i = 0; i < 14; i++) developmentCards.add(new DevelopmentCard(DevelopmentType.KNIGHT));
        for(int i = 0; i < 5; i++) developmentCards.add(new DevelopmentCard(DevelopmentType.VICTORYPOINT));
        for(int i = 0; i < 2; i++) developmentCards.add(new DevelopmentCard(DevelopmentType.MONOPOLY));
        for(int i = 0; i < 2; i++) developmentCards.add(new DevelopmentCard(DevelopmentType.ROADBUIDER));
        for(int i = 0; i < 2; i++) developmentCards.add(new DevelopmentCard(DevelopmentType.YEAROFPLENTY));
        Collections.shuffle(developmentCards);
    }

    public void returnResource(ResourceType resource){
        assert resourceCards.get(resource) < 19;
        resourceCards.put(resource, resourceCards.get(resource) + 1);
    }

    public ResourceType getResource(ResourceType resource){
        int count = resourceCards.get(resource);
        assert count >= 0;
        if(count == 0) return ResourceType.EMPTY;
        resourceCards.put(resource, count - 1);
        return resource;
    }

    public void returnDevelopmentCard(DevelopmentCard developmentCard){
        developmentCards.add(developmentCard);
    }

    public DevelopmentCard getDevelopmentCard(){
        if(developmentCards.isEmpty()) return new DevelopmentCard(DevelopmentType.EMPTY);
        return developmentCards.removeFirst();
    }

}
