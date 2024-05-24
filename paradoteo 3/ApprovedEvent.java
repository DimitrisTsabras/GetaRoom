package models;

import java.util.Date;

public class ApprovedEvent {
    private String title;
    private String description;
    private Date time;
    private int expectedPeople;
    private ApprovedRoom approvedRoom;

    public ApprovedEvent(String title, String description, Date time, int expectedPeople, ApprovedRoom approvedRoom) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.expectedPeople = expectedPeople;
        this.approvedRoom = approvedRoom;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getTime() {
        return time;
    }

    public int getExpectedPeople() {
        return expectedPeople;
    }

    public ApprovedRoom getApprovedRoom() {
        return approvedRoom;
    }
}
