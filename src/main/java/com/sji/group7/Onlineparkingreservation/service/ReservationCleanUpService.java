package com.sji.group7.Onlineparkingreservation.service;

import com.sji.group7.Onlineparkingreservation.model.ParkingSpot;
import com.sji.group7.Onlineparkingreservation.model.ParkingSpotStatus;
import com.sji.group7.Onlineparkingreservation.model.Reservation;
import com.sji.group7.Onlineparkingreservation.model.ReservationState;
import com.sji.group7.Onlineparkingreservation.repository.ParkingSpotRepo;
import com.sji.group7.Onlineparkingreservation.repository.ReservationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationCleanUpService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private ParkingSpotRepo parkingSpotRepo;

    @Scheduled(fixedRate = 5*60*1000)
    @Transactional
    public void releaseExpiredSpots(){
        List<Reservation> expiredReservations = reservationRepo.
                findReservationsByStateAndEndTimeBefore(ReservationState.Confirmed, LocalTime.now());

        expiredReservations.addAll(reservationRepo.
                findReservationsByStateAndEndTimeBefore(ReservationState.Cancelled, LocalTime.now()));

        expiredReservations.forEach(reservation -> {
            ParkingSpot spot = reservation.getParkingSpot();
            if(spot != null){
                spot.setStatus(ParkingSpotStatus.Available);
                reservation.setState(ReservationState.Completed);
                parkingSpotRepo.save(spot);
                reservationRepo.save(reservation);
            }
        });

    }

}
