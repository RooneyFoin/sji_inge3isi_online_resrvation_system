package com.sji.group7.Onlineparkingreservation.repository;

import com.sji.group7.Onlineparkingreservation.model.*;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
    List<Reservation> findReservationsByUser_Id(Integer userId);

    List<Reservation> findByDeletedFalse();

    List<Reservation> findByStateAndDeletedFalse(ReservationState state);

    List<Reservation> findReservationsByParkingLot(ParkingLot parkingLot);

    List<Reservation> findReservationsByParkingLot_ParkingLotID(Integer parkingSpotID);

    List<Reservation> findReservationsByStateAndEndTimeBefore(ReservationState state, LocalTime endTime);
}
