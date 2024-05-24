package models;

import java.io.Serializable;
import java.util.Date;

public class ReservationRequest implements Serializable {
    private String studentName;
    private Room room;
    private Date date;
    private String time;
    private String eventTitle;

    public ReservationRequest(String studentName, Room room, Date date, String time, String eventTitle) {
        this.studentName = studentName;
        this.room = room;
        this.date = date;
        this.time = time;
        this.eventTitle = eventTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    @Override
    public String toString() {
        return "Reservation Request by " + studentName + "\nRoom: " + room + "\nDate: " + date + "\nTime: " + time + "\nEvent: " + eventTitle;
    }
}
