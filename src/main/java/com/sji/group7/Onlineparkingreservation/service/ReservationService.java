package com.sji.group7.Onlineparkingreservation.service;

import com.sji.group7.Onlineparkingreservation.model.Reservation;
import com.sji.group7.Onlineparkingreservation.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    public Optional<Reservation> getReservationById(String reservationID) {
        return reservationRepo.findById(reservationID);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }
}
