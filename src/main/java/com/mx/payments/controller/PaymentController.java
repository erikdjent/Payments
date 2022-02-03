package com.mx.payments.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.payments.model.Payment;
import com.mx.payments.model.ResponsePaymentList;
import com.mx.payments.repository.ListPaymentRepository;
import com.mx.payments.repository.PaymentRepository;
import com.mx.payments.util.PaymentUtil;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	ListPaymentRepository listPaymentRepository;
	
	
	@PostMapping("/getPay")
	public ResponseEntity<List<ResponsePaymentList>> getPayments(@RequestBody Payment payment) {
		try {
			List<ResponsePaymentList> _payList =
			listPaymentRepository.saveAll(PaymentUtil.calculatePayments(paymentRepository
					.save(new Payment(payment.getAmount(), payment.getTerms(), payment.getRate()))));	
			return new ResponseEntity<>(_payList, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
