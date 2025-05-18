package com.sji.group7.Onlineparkingreservation.repository;

import com.sji.group7.Onlineparkingreservation.model.ParkingLot;
import com.sji.group7.Onlineparkingreservation.model.ParkingSpot;
import com.sji.group7.Onlineparkingreservation.model.ParkingSpotStatus;
import com.sji.group7.Onlineparkingreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
    List<Reservation> findReservationsByUser_Id(Integer userId);

    List<Reservation> findReservationsByParkingLot(ParkingLot parkingLot);

    List<Reservation> findReservationsByParkingLot_ParkingLotID(Integer parkingSpotID);

}
