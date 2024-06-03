package com.parkingLot;

import java.time.LocalDateTime;

public record Ticket(
        long ticketId,
        String plate,
        String parkingLot,
        LocalDateTime entryTime,
        LocalDateTime exitTime,
        double charge
) {
}
