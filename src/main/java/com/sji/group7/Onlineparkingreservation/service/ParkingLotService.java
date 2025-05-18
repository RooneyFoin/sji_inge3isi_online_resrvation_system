package com.sji.group7.Onlineparkingreservation.service;

import com.sji.group7.Onlineparkingreservation.dtos.ParkingLotDto;
import com.sji.group7.Onlineparkingreservation.model.ParkingLot;
import com.sji.group7.Onlineparkingreservation.model.ParkingSpot;
import com.sji.group7.Onlineparkingreservation.repository.ParkingLotRepo;
import com.sji.group7.Onlineparkingreservation.repository.ParkingSpotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepo parkingLotRepo;

    @Autowired
    private ParkingSpotRepo parkingSpotRepo;

    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepo.save(parkingLot);
    }

    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepo.findAll();}

    public Optional<ParkingLot> getParkingLotById(String id) {
        return parkingLotRepo.findById(id);
    }

    public ParkingLotDto toparkingLotDto(ParkingLot parkingLot) {
        List<ParkingSpot> spots = parkingSpotRepo.findParkingSpotsByParkingLot(parkingLot);

        return ParkingLotDto.builder()
                .parkingLotID(parkingLot.getParkingLotID())
                .location(parkingLot.getLocation())
                .totalSpots(parkingLot.getTotalSpots())
                .parkingSpots(spots)
                .build();
    }

}
