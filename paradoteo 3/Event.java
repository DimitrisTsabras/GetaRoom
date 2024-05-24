package models;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String shortDescription;
    private String imagePath;
    private String longDescription;
    private int expectedPeople;
    private String room;
    private List<User> participants;

    public Event(String name, String shortDescription, String imagePath, String longDescription, int expectedPeople, String room) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.imagePath = imagePath;
        this.longDescription = longDescription;
        this.expectedPeople = expectedPeople;
        this.room = room;
        this.participants = new ArrayList<>();
    }

    public String getLongDescription() {
        return longDescription;
    }

    public int getExpectedPeople() {
        return expectedPeople;
    }

    public String getRoom() {
        return room;
    }

    public String getTitle() {
        return name;
    }

    public int getExpectedParticipants() {
        return expectedPeople;
    }

    public String getSuggestedRoom() {
        return room;
    }

    public int getCurrentParticipants() {
        return participants.size();
    }

    public void join(User user) {
        participants.add(user);
    }

    public void cancelJoin(User user) {
        participants.remove(user);
    }

    public byte[] getImagePath() {
        return imagePath.getBytes();
    }

    public String getShortDescription() {
        return shortDescription;
    }


    // other methods...
}