package com.example.loan.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.loan.model.entity.PaymentSchedule;

public interface PaymentScheduleRepository extends CrudRepository<PaymentSchedule, Long>{

	List<PaymentSchedule> findByLoanDetailsId(int id);
}
