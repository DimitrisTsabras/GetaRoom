package models;

public class ApprovedRoom {
    private String name;
    private int capacity;

    public ApprovedRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
