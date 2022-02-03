package com.mx.payments.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.payments.model.ResponsePaymentList;

public interface ListPaymentRepository extends JpaRepository<ResponsePaymentList, Integer>{
	
}
