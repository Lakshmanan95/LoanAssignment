package com.example.loan.model.loan;

import java.util.List;

import com.example.loan.common.BaseResponse;
import com.example.loan.model.entity.LoanDetails;
import com.example.loan.model.entity.PaymentSchedule;

public class LoanResponse extends BaseResponse{

	private List<LoanDetails> loanDetails;
	private LoanDetails loan;
	List<PaymentSchedule> paymentSchedule;
	
	public List<LoanDetails> getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(List<LoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}
	public LoanDetails getLoan() {
		return loan;
	}
	public void setLoan(LoanDetails loan) {
		this.loan = loan;
	}
	public List<PaymentSchedule> getPaymentSchedule() {
		return paymentSchedule;
	}
	public void setPaymentSchedule(List<PaymentSchedule> paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}
	
	
}
