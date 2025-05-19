package com.sji.group7.Onlineparkingreservation.controller.api;

import com.sji.group7.Onlineparkingreservation.dtos.LocationDto;
import com.sji.group7.Onlineparkingreservation.model.Location;
import com.sji.group7.Onlineparkingreservation.model.Reservation;
import com.sji.group7.Onlineparkingreservation.service.LocationService;
import com.sji.group7.Onlineparkingreservation.service.ParkingLotService;
import com.sji.group7.Onlineparkingreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservationApi {

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllParkingLots() {
        List<Location> locations = locationService.getAllLocations();
        List<LocationDto> locationDTOs = new ArrayList<>();

        for (Location location : locations) {
            locationDTOs.add(locationService.toDto(location));
        }
        return ResponseEntity.ok(locationDTOs);
    }

    //To be modified to fit what is gotten from the front end
    //i.e. the endpoint and the request body
    //and finally add the remaining fields for a reservation to be complete
    @PostMapping("/add-reservation")
    public ResponseEntity<Reservation> reserveParkingLot(@RequestBody Reservation reservation) {
        Reservation reserve = new Reservation();

        reserve.setCurrentDate(LocalDateTime.now());
        reserve.setReservationDate(reservation.getReservationDate());
        reserve.setStartTime(reservation.getStartTime());
        reserve.setEndTime(reservation.getEndTime());
        reserve.setDuration(reservation.getDuration());
        reserve.setCost(reservation.getCost());

        Reservation reserved = reservationService.saveReservation(reserve);
        return ResponseEntity.ok(reserved);
    }
}
