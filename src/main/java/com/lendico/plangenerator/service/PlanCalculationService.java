package com.lendico.plangenerator.service;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lendico.plangenerator.model.LoanDetails;
import com.lendico.plangenerator.model.PaymentDetails;



@Service
public class PlanCalculationService {
	final static private int DAYS_IN_MONTH = 30;
	final static private int DAYS_IN_YEAR = 360;
	final static private int MONTH_IN_YEAR = 12;
	final static private double RATIO = 100.0;

	public List<PaymentDetails> getPaymentDetails(LoanDetails loanDetails){
		
		
		List<PaymentDetails> paymentDetailsList = new ArrayList<PaymentDetails>();
		double initialOutstandingPrincipal = loanDetails.getLoanAmount();
		double annuity = calculateTotalAnnuity(loanDetails);
		double remainingOutstandingPrincipal = initialOutstandingPrincipal;
		LocalDate paymentDate = convertStringToDate(loanDetails.getStartDate());
		paymentDate = paymentDate.minusMonths(1);
		
		while(remainingOutstandingPrincipal > 0){
			
			initialOutstandingPrincipal = remainingOutstandingPrincipal;
			double interest = calculateInterest(loanDetails.getNominalRate(), initialOutstandingPrincipal);
			double  principal = annuity - interest;
			if(principal > initialOutstandingPrincipal)
				initialOutstandingPrincipal = principal;
			remainingOutstandingPrincipal = initialOutstandingPrincipal - principal;
			
			paymentDate = paymentDate.plusMonths(1);
			PaymentDetails paymentDetails = setPaymentDetails(paymentDate, initialOutstandingPrincipal,
						remainingOutstandingPrincipal, annuity, interest, principal);
				paymentDetailsList.add(paymentDetails);
			 
			 
		}
		return paymentDetailsList;
	}

	private PaymentDetails setPaymentDetails(LocalDate paymentDate, double initialOutstandingPrincipal,
			double remainingOutstandingPrincipal, double annuity, double interest, double principal) {
		
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAnnuity(annuity);
		paymentDetails.setInterest(interest);
		paymentDetails.setPrincipal(principal);
		paymentDetails.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);
		paymentDetails.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
		paymentDetails.setPaymentDate(paymentDate);
		
		
		return paymentDetails;
	}

	private double calculateInterest(double nominalRate, double currentAmount) {
		double interestRate = nominalRate/RATIO;
		return (interestRate*DAYS_IN_MONTH*currentAmount / DAYS_IN_YEAR);		
	}

	private double calculateTotalAnnuity(LoanDetails loanDetails) {
		double loanAmount = loanDetails.getLoanAmount();
		double interestRate = loanDetails.getNominalRate() / RATIO;
		double monthlyRate = interestRate / MONTH_IN_YEAR;
		int period = loanDetails.getDuration();
		double monthlyPayment = (loanAmount*monthlyRate) / (1-Math.pow(1+monthlyRate, -period));
		
		return monthlyPayment;
		
	}
	
	private LocalDate convertStringToDate(String dateInString){
		Instant instant = Instant.parse(dateInString);
		LocalDateTime result = LocalDateTime.ofInstant(instant,ZoneId.of(ZoneOffset.UTC.getId()));
		return result.toLocalDate();
	}
}
