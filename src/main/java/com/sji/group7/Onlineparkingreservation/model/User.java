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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(unique = true,nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String role;

    @OneToMany
    @JoinColumn(name = "payment_id")
    private List<Payment> payments;

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<Reservation> reservations;
}
