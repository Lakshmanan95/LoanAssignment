package com.example.loan.dao;

import java.util.List;

import com.example.loan.model.entity.LoanDetails;

public interface LoanDAO {

	public List<LoanDetails> getAllLoansByCustomer(int customerId);
}
