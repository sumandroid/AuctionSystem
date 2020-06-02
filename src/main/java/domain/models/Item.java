package domain.models;

public class Item {

    private String name;
    private float cost;

    public Item(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
