package com.lendico.plangenerator.model;



public class LoanDetails {
	
	@Override
	public String toString() {
		return "LoanDetails [loanAmount=" + loanAmount + ", nominalInterestRate=" + nominalRate + ", duration="
				+ duration + ", paymentDate=" + startDate + "]";
	}
	double loanAmount;
	double nominalRate;
	int duration;
	String startDate;
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getNominalRate() {
		return nominalRate;
	}
	public void setNominalRate(double nominalInterestRate) {
		this.nominalRate = nominalInterestRate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	

}
