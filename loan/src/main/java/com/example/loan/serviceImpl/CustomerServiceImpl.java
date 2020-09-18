package com.example.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.model.entity.Customer;
import com.example.loan.repo.CustomerRepository;
import com.example.loan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}
}
