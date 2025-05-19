package com.sji.group7.Onlineparkingreservation.controller.api;

import com.sji.group7.Onlineparkingreservation.dtos.LocationDto;
import com.sji.group7.Onlineparkingreservation.model.Location;
import com.sji.group7.Onlineparkingreservation.model.Reservation;
import com.sji.group7.Onlineparkingreservation.model.ReservationState;
import com.sji.group7.Onlineparkingreservation.service.LocationService;
import com.sji.group7.Onlineparkingreservation.service.ParkingLotService;
import com.sji.group7.Onlineparkingreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        reserve.setState(ReservationState.Confirmed);
        reserve.setCost(reservation.getCost());

        Reservation reserved = reservationService.saveReservation(reserve);
        return ResponseEntity.ok(reserved);
    }

    //used to cancel a reservation but needs to be checked when the front end will be available
    @PatchMapping("/cancel-reservation")
    public ResponseEntity<Void> cancelReservation(Integer reservationId) {

       reservationService.cancelReservation(reservationId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-reservation")
    public ResponseEntity<Void> deleteReservation(Integer reservationId) {

        reservationService.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }

    //this get mapping is for the users to view just the reservations
    // they have not deleted from their history
    //it still has to be fixed so that it fetches just for a particular user
    @GetMapping("/history")
    public ResponseEntity<List<Reservation>> getAllReservations() {

        List<Reservation> reservations = reservationService.getActiveReservations();
        return ResponseEntity.ok(reservations);
    }
}
