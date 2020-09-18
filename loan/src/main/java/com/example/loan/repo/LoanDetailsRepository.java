package com.example.loan.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.loan.model.entity.LoanDetails;

public interface LoanDetailsRepository extends CrudRepository<LoanDetails, Long>{

	List<LoanDetails> findByCustomerId(int customerId);
}
