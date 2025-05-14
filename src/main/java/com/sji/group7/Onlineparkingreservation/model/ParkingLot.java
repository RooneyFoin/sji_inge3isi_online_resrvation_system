package com.sji.group7.Onlineparkingreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParkingLot {

    @Id
    private String parkingLotID;

    private String location;
    private int totalSpots;

//    @OneToMany
//    private List<ParkingSpot>  parkingSpots;
}
