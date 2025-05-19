package com.sji.group7.Onlineparkingreservation.service;

import com.sji.group7.Onlineparkingreservation.dtos.ParkingSpotDto;
import com.sji.group7.Onlineparkingreservation.model.ParkingLot;
import com.sji.group7.Onlineparkingreservation.model.ParkingSpot;
import com.sji.group7.Onlineparkingreservation.repository.ParkingLotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingLotRepo parkingLotRepo;

    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepo.save(parkingLot);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLotRepo.findAll();
    }

    public Optional<ParkingLot> getParkingLot(String parkingLotID) {
        return parkingLotRepo.findById(parkingLotID);
    }

    public ParkingSpotDto toDto(ParkingSpot parkingSpot) {
        return ParkingSpotDto.builder()
                .parkingSpotId(parkingSpot.getParkingSpotID())
                .parkingSpotStatus(parkingSpot.getStatus())
                .build();
    }
}
