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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentID;

    private Date paymentDate;
    private int amount;
    private Method paymentMethod;

    @OneToOne
    private Reservation reservation;

    @ManyToOne
    private User user;
}
