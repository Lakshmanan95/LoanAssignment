package com.example.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.common.CommonConstant;
import com.example.loan.common.LoanProjectLogger;
import com.example.loan.model.entity.Customer;
import com.example.loan.model.loan.CustomerResponse;
import com.example.loan.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public CustomerResponse saveCustomer(@RequestBody Customer customer) {
		CustomerResponse response = new CustomerResponse();
		try {
			Customer saveCustomer = customerService.saveCustomer(customer);
			if(saveCustomer != null) {
				response.setCustomer(saveCustomer);
				LoanProjectLogger.logInfo(getClass(), CommonConstant.DATA_ADDED);
			}
			else {
				response.setStatus(CommonConstant.ERROR);
				response.setErrorCode(101);
				LoanProjectLogger.logInfo(getClass(), CommonConstant.DATA_FAILED);
			}
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			response.setErrorCode(101);
			LoanProjectLogger.logError(getClass(), CommonConstant.DATA_FAILED,e);
		}
		return response;
	}
}
