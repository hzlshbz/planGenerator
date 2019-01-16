package com.lendico.plangenerator.model;

import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentDetails {
	
	
	LocalDate paymentDate;
	double annuity;
	double principal;
	double interest;
	double initialOutstandingPrincipal;
	double remainingOutstandingPrincipal;
	
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAnnuity() {
		return annuity;
	}
	public void setAnnuity(double annuity) {
		this.annuity = annuity;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	public double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
	public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	} 
	
	
}
