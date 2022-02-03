package com.mx.payments.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mx.payments.model.Payment;
import com.mx.payments.model.ResponsePaymentList;


public class PaymentUtil {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	private static DateFormat format = new SimpleDateFormat("yyyyMMdd");


	public static List<ResponsePaymentList> calculatePayments(Payment payment) throws ParseException {

		List<ResponsePaymentList> list = new ArrayList<ResponsePaymentList>();

		Double rateAmount = payment.getAmount() * (payment.getRate() / 100);
		Double totalAmount = payment.getAmount() + Double.valueOf(df.format(rateAmount));
		String termsAmount = df.format(totalAmount / payment.getTerms());

		List<Date> listDates = calculatePaymentsDates(payment.getTerms());

		for (int i = 1; i <= payment.getTerms(); i++) {

			list.add(new ResponsePaymentList(i, Double.valueOf(Math.round(Double.valueOf(termsAmount))), listDates.get(i-1)));

		}

		return list;
	}

	public static List<Date> calculatePaymentsDates(Integer terms) throws ParseException {

		List<Date> paymentDates = new ArrayList<Date>();

		for (int i = 1; i <= terms; i++) {
			paymentDates.add(format.parse(getSystemDate(i)));
		}

		return paymentDates;

	}
	
	public static final String getSystemDate(int mes) {
		Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH) + 1;
		month = month + mes;
		int day = date.get(Calendar.DAY_OF_MONTH);
		String systemDate = String.valueOf(year) + String.format("%02d", month) + String.format("%02d", day);
		return systemDate;
	}

}
