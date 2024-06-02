// ParkingService.java
package com.parkingLot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ParkingService {

    private static final double RATE_PER_HOUR = 10.0;

    @Autowired
    private InMemoryTicketRepository repository;

    public Ticket enterParking(String plate, String parkingLot) {
        Ticket ticket = new Ticket();
        ticket.setPlate(plate);
        ticket.setParkingLot(parkingLot);
        ticket.setEntryTime(LocalDateTime.now());
        ticket = repository.save(ticket);
        return ticket;
    }

    public Ticket exitParking(Long ticketId) {
        Ticket ticket = repository.findById(ticketId);
        if (ticket != null) {
            ticket.setExitTime(LocalDateTime.now());
            Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
            double hours = duration.toMinutes() / 60.0;
            ticket.setCharge(Math.ceil(hours) * RATE_PER_HOUR);
            repository.update(ticket);
        }
        return ticket;
    }
}
