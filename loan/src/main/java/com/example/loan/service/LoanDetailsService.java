package com.example.loan.service;

import java.util.List;

import com.example.loan.model.entity.LoanDetails;
import com.example.loan.model.entity.PaymentSchedule;
import com.example.loan.model.loan.LoanResponse;

public interface LoanDetailsService {

	public LoanResponse saveLoanDetails(LoanDetails loanDetails);
	
	public List<LoanDetails> getAllLoansByCustomer(int customerId);
	
	public PaymentSchedule savePaymentSchedule(PaymentSchedule paymentSchedule);
	
	public List<PaymentSchedule> getPaymentScheduleByLoan(int loanDetailsId);
}
