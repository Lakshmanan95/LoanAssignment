package com.example.loan.model.loan;

public class LoanRequest {

	private int loanDetailsId;
	private int paymentScheduleId;
	public int getLoanDetailsId() {
		return loanDetailsId;
	}
	public void setLoanDetailsId(int loanDetailsId) {
		this.loanDetailsId = loanDetailsId;
	}
	public int getPaymentScheduleId() {
		return paymentScheduleId;
	}
	public void setPaymentScheduleId(int paymentScheduleId) {
		this.paymentScheduleId = paymentScheduleId;
	}
	
	
}
