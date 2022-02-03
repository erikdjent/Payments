package com.mx.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.payments.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
