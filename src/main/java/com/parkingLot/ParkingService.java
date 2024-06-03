package com.parkingLot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ParkingService {

    private static final double RATE_PER_HOUR = 10.0;

    @Autowired
    private InMemoryTicketRepository repository;

    public Ticket enterParking(String plate, String parkingLot) {
        return repository.save(new Ticket(
                null,
                plate,
                parkingLot,
                LocalDateTime.now(),
                null,
                0
        ));
    }

    public Ticket exitParking(Long ticketId) {
        Ticket ticket = repository.findById(ticketId);
        if (Objects.nonNull(ticket)) {
            return repository.update(new Ticket(
                    ticket.ticketId(),
                    ticket.plate(),
                    ticket.parkingLot(),
                    ticket.entryTime(),
                    LocalDateTime.now(),
                    Duration.between(ticket.entryTime(), ticket.exitTime()).toHours() * RATE_PER_HOUR
            ));
        }
        return null;
    }
}
