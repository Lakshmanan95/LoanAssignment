package com.example.loan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.common.CommonConstant;
import com.example.loan.common.LoanProjectLogger;
import com.example.loan.model.entity.LoanDetails;
import com.example.loan.model.entity.PaymentSchedule;
import com.example.loan.model.loan.LoanRequest;
import com.example.loan.model.loan.LoanResponse;
import com.example.loan.service.LoanDetailsService;

@RestController
@RequestMapping("/loanDetails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoanController {

	@Autowired
	LoanDetailsService loanDetailsService;
	
	
	@PostMapping("/saveLoan")
	public LoanResponse saveLoanDetails(@RequestBody LoanDetails loan) {
		LoanResponse response = new LoanResponse();
		try {
			response = loanDetailsService.saveLoanDetails(loan);
			LoanProjectLogger.logInfo(getClass(), CommonConstant.LOAN_ADDED);
		}
		catch(Exception e) {
			LoanProjectLogger.logError(getClass(), CommonConstant.LOAN_ADDED_FAILED, e);
			response.setStatus(CommonConstant.ERROR);
			response.setErrorCode(101);
		}
		return response;
	}
	
	@PostMapping("/getLoanByUser")
	public LoanResponse getAllLoans(@RequestBody LoanDetails loan) {
		LoanResponse response = new LoanResponse();
		try {
			List<LoanDetails> loanDetails = new ArrayList<>();
			if(loan.getCustomerId() != 0) {
				loanDetails = loanDetailsService.getAllLoansByCustomer(loan.getCustomerId());
				response.setLoanDetails(loanDetails);
				LoanProjectLogger.logInfo(getClass(), CommonConstant.GET_LOANS);
			}
			else {
				LoanProjectLogger.logInfo(getClass(), CommonConstant.INVALID_DATA);
				response.setStatus(CommonConstant.ERROR);
				response.setErrorCode(102);
			}
		}
		catch(Exception e) {
			LoanProjectLogger.logError(getClass(), CommonConstant.GET_LOAN_FAILED, e);
			response.setStatus(CommonConstant.ERROR);
			response.setErrorCode(101);
		}
		return response;
	}
	
	@GetMapping("/getPaymentScheduleByLoan/{id}")
	public LoanResponse getPaymentScheduleByLoan(@PathVariable int id) {
		LoanResponse response = new LoanResponse();
		try {
			List<PaymentSchedule> paymentSchedule = new ArrayList<>();
			if(id != 0) {
				paymentSchedule = loanDetailsService.getPaymentScheduleByLoan(id);
				response.setPaymentSchedule(paymentSchedule);
				LoanProjectLogger.logInfo(getClass(), CommonConstant.GET_LOANS);
			}
			else {
				LoanProjectLogger.logInfo(getClass(), CommonConstant.INVALID_DATA);
				response.setStatus(CommonConstant.ERROR);
				response.setErrorCode(102);
			}
				
		}
		catch(Exception e) {
			LoanProjectLogger.logError(getClass(), CommonConstant.GET_LOAN_FAILED, e);
			response.setStatus(CommonConstant.ERROR);
			response.setErrorCode(101);
		}
		return response;
	}
	
}
