package com.example.loan.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.loan.model.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
