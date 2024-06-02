// Ticket.java
package com.parkingLot;

import java.time.LocalDateTime;

public class Ticket {
    private Long ticketId;
    private String plate;
    private String parkingLot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double charge;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    // Getters and setters
}
