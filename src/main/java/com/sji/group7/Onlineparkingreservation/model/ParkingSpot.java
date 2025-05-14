package com.sji.group7.Onlineparkingreservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpot {

    @Id
    private String parkingSpotID;

//    private String location;

    @Enumerated(EnumType.STRING)
    private ParkingSpotStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private ParkingLot parkingLot;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservations;

}
