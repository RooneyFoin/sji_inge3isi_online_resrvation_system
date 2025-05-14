package com.sji.group7.Onlineparkingreservation.repository;

import com.sji.group7.Onlineparkingreservation.model.ParkingSpot;
import com.sji.group7.Onlineparkingreservation.model.ParkingSpotStatus;
import com.sji.group7.Onlineparkingreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,String> {
    List<Reservation> findReservationsByUser_Id(int userId);

    List<Reservation> findReservationsByParkingSpot(ParkingSpot parkingSpot);

    List<Reservation> findReservationsByParkingSpot_ParkingSpotID(String parkingSpotID);

    List<Reservation> findReservationsByParkingSpot_Status(ParkingSpotStatus parkingSpotStatus);

    List<Reservation> findAllByDate(Date date);
}
