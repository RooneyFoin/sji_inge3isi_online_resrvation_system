package com.sji.group7.Onlineparkingreservation.repository;

import com.sji.group7.Onlineparkingreservation.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
