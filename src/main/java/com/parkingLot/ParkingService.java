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
                    calculateCost(ticket.entryTime(), LocalDateTime.now())
            ));
        }
        return null;
    }

    public static double calculateCost(LocalDateTime entryTime, LocalDateTime exitTime) {
        // Calculate the duration between entry and exit times
        Duration duration = Duration.between(entryTime, exitTime);

        // Get the total minutes of the duration
        long totalMinutes = duration.toMinutes();

        // Calculate the cost based on 10 dollars per hour and 2.5 dollars per 15 minutes
        double cost = (double) (totalMinutes / 60) * RATE_PER_HOUR; // Full hours cost
        cost += (double) ((totalMinutes % 60) / 15) * 2.5; // Remaining 15-minute intervals cost

        return cost;
    }
}
