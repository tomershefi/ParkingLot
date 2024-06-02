// InMemoryTicketRepository.java
package com.parkingLot;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTicketRepository {

    private final Map<Long, Ticket> tickets = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public Ticket save(Ticket ticket) {
        long id = idCounter.incrementAndGet();
        ticket.setTicketId(id);
        tickets.put(id, ticket);
        return ticket;
    }

    public Ticket findById(Long ticketId) {
        return tickets.get(ticketId);
    }

    public void update(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }
}
