package com.example.loan.model.loan;

import com.example.loan.common.BaseResponse;
import com.example.loan.model.entity.Customer;

public class CustomerResponse extends BaseResponse{

	Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
