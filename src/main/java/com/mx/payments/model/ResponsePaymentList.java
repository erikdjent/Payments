package com.mx.payments.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "list_payments")
public @Data class ResponsePaymentList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTerm;
	
	@Column(name = "paymentNumber")
	private Integer paymentNumber;
	
	@Column(name = "amountTerm")
	private Double amount;
	
	@Column(name = "paymentDate")
	private Date paymentDate;

	
	public ResponsePaymentList(Integer paymentNumber, Double amount, Date paymentDate) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	

}
