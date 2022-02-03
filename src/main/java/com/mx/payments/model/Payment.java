package com.mx.payments.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payments")
public @Data class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPayment;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "terms")
	private Integer terms;
	
	@Column(name = "rate")
	private Double rate;
	
	
	public Payment() {}
	
	public Payment(Double amount, Integer terms, Double rate) {
		super();
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}
	
}
