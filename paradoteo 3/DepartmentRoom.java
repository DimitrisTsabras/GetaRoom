package models;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRoom {
    private final String name;
    private final int capacity;
    private final List<RequestInfo> bookings;
    private final String specialRequirements;

    public DepartmentRoom(String name, int capacity, String specialRequirements) {
        this.name = name;
        this.capacity = capacity;
        this.bookings = new ArrayList<>();
        this.specialRequirements = specialRequirements;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public List<RequestInfo> getBookings() { return new ArrayList<>(bookings); }
    public String getSpecialRequirements() { return specialRequirements; }

    public boolean checkAvailability(String date) {
        // Logic to check availability
        // Placeholder logic, this should be more detailed based on actual requirements
        return bookings.stream().noneMatch(booking -> booking.getDatetime().toString().contains(date));
    }

    public void book(RequestInfo requestInfo) {
        bookings.add(requestInfo);
        System.out.println("Room " + name + " booked for " + requestInfo.getDatetime());
    }
}
