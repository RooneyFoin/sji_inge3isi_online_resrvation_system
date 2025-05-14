package com.sji.group7.Onlineparkingreservation.repository;

import com.sji.group7.Onlineparkingreservation.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpotRepo extends JpaRepository<ParkingSpot,String> {

    List<ParkingSpot> findByParkingLotID(String parkingLotID);

    ParkingSpot findParkingSpotByParkingSpotID(String parkingSpotID);

}
