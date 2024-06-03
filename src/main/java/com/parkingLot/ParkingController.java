package com.parkingLot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("entry")
    public Ticket entry(@RequestParam String plate, @RequestParam String parkingLot) {
        return parkingService.enterParking(plate, parkingLot);
    }

    @PostMapping("exit")
    public Ticket exit(@RequestParam long ticketId) {
        return parkingService.exitParking(ticketId);
    }
}
