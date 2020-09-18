package com.example.loan.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.loan.dao.LoanDAO;
import com.example.loan.model.entity.LoanDetails;

@Service
@Transactional
public class LaonDAOImpl implements LoanDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<LoanDetails> getAllLoansByCustomer(int customerId){
		String query = "Select * from loan_details where customer_id ="+customerId+" order by id Desc";
		List<LoanDetails> loanDetails = jdbcTemplate.query(query,  new BeanPropertyRowMapper(LoanDetails.class));
		return loanDetails;
	}
}
