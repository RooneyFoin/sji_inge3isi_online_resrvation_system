package com.sji.group7.Onlineparkingreservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Reservation implements Serializable {

    @Id
    private String reservationID;

    private Date date;
    private Time startTime;
    private Time endTime;

    @Enumerated(EnumType.STRING)
    private ReservationState state;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpot parkingSpot;
}
