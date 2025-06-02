package com.sji.group7.Onlineparkingreservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming you want it to auto-generate
    private Integer paymentID; // Change to Integer to match reservationID type

    private Date paymentDate;
    private int amount;

    @Enumerated(EnumType.STRING)
    private Method paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY) // Change to ManyToOne if applicable
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservationID") // Ensure this matches
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}