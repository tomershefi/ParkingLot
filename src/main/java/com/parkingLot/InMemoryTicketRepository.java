package com.parkingLot;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTicketRepository {

    private final Map<Long, Ticket> tickets = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public Ticket save(Ticket ticket) {
        long id = idCounter.incrementAndGet();
        final Ticket value = new Ticket(
                id,
                ticket.plate(),
                ticket.parkingLot(),
                ticket.entryTime(),
                ticket.exitTime(),
                ticket.charge()
        );
        tickets.put(id, value);
        return value;
    }

    public Ticket findById(Long ticketId) {
        return tickets.get(ticketId);
    }

    public Ticket update(Ticket ticket) {
        tickets.put(ticket.ticketId(), ticket);
        return ticket;
    }
}
