package models;

import java.util.Date;

public class RequestInfo {
    private final Date datetime;
    private final int duration;
    private final DepartmentRoom room;

    public RequestInfo(Date datetime, int duration, DepartmentRoom room) {
        this.datetime = datetime;
        this.duration = duration;
        this.room = room;
    }

    public Date getDatetime() { return datetime; }
    public int getDuration() { return duration; }
    public DepartmentRoom getRoom() { return room; }

    public String getRequestInfo() {
        return String.format("Request Info: DateTime: %s, Duration: %d, Room: %s", datetime, duration, room.getName());
    }
}
