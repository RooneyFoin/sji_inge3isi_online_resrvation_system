package com.sji.group7.Onlineparkingreservation.controller.api;

import com.sji.group7.Onlineparkingreservation.dtos.ParkingLotDto;
import com.sji.group7.Onlineparkingreservation.model.ParkingLot;
import com.sji.group7.Onlineparkingreservation.model.Reservation;
import com.sji.group7.Onlineparkingreservation.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservationApi {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    public ResponseEntity<List<ParkingLotDto>> getAllParkingLots() {
        List<ParkingLotDto> parkingLotDTO = new ArrayList<>();
        List<ParkingLot> parkingLots = parkingLotService.getAllParkingLots();

        for (ParkingLot parkingLot : parkingLots) {
            parkingLotDTO.add(parkingLotService.toparkingLotDto(parkingLot));
        }

        return ResponseEntity.ok(parkingLotDTO);
    }

    @PostMapping("/add-reservation")
    public ResponseEntity<Reservation> reserveParkingLot(@RequestBody Reservation reservation) {
        Reservation reserved = new Reservation();

        reserved.setCurrentDate(LocalDateTime.now());
        reserved.setReservationDate(reservation.getReservationDate());
        reserved.setStartTime(reservation.getStartTime());
        //Either we take an end date and time and calculate the duration and cost
        reserved.setEndTime(reservation.getEndTime());
        //Or we
        return ResponseEntity.ok(reserved);
    }
}
