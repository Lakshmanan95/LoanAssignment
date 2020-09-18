package com.example.loan.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.common.CommonConstant;
import com.example.loan.common.LoanProjectLogger;
import com.example.loan.dao.LoanDAO;
import com.example.loan.model.entity.LoanDetails;
import com.example.loan.model.entity.PaymentSchedule;
import com.example.loan.model.loan.LoanResponse;
import com.example.loan.repo.LoanDetailsRepository;
import com.example.loan.repo.PaymentScheduleRepository;
import com.example.loan.service.LoanDetailsService;
import com.example.loan.util.DateAndTimeUtil;
import com.example.loan.util.JSONUtil;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService{

	@Autowired
	LoanDetailsRepository loanDetailsRepository;
	
	@Autowired
	PaymentScheduleRepository paymentScheduleRepository;
	
	@Autowired
	LoanDAO loanDAO;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public LoanResponse saveLoanDetails(LoanDetails loanDetails) {
		LoanResponse response = new LoanResponse();
		try {
			LoanDetails loan = loanDetailsRepository.save(loanDetails);
			LoanProjectLogger.logInfo(getClass(), CommonConstant.LOAN_SAVED);
			paymentScheduleProcess(loan);
			
		}catch(Exception e) {
			LoanProjectLogger.logError(getClass(), CommonConstant.LOAN_PROCESS_FAILED, e);
		}
		
		return response;
	}
	
	public void paymentScheduleProcess(LoanDetails loan)  throws ParseException{
		List<PaymentSchedule> paymentScheduleList = new ArrayList<>();
		int totalMonths = getDateDifference(loan.getLoanStartDate(),loan.getMaturityDate());
		int paymentSchedule = totalMonths/loan.getPaymentFrequency();
		double projectedInterest = 0;
		double temp = loan.getLoanAmount();
		for(int i = 0; i <= paymentSchedule; i = i+loan.getPaymentFrequency()) {
			PaymentSchedule schedule = new PaymentSchedule();
			Calendar cal = new GregorianCalendar();
			cal.setTime(format.parse(loan.getLoanStartDate()));
			cal.add(Calendar.MONTH, i);
			schedule.setLoanDetailsId(loan.getId());
			schedule.setPaymentDate(DateAndTimeUtil.changeDatetoString(cal.getTime()));
			double principalAmount = Math.round((loan.getLoanAmount()/paymentSchedule) * 100.0)/100.0;
			schedule.setPrincipal(principalAmount);
			double paymentAmount = Math.round((projectedInterest * loan.getInterestRate() / 100) * 100.0)/100.0;
			schedule.setPaymentAmount(paymentAmount);
				if(i == 0) {
					projectedInterest = temp;
				}
				else {
					
					projectedInterest = temp - (loan.getLoanAmount()/paymentSchedule);
					temp = projectedInterest;
				}
				double projectInterest = Math.round(temp * 100.0)/100.0;
				schedule.setProjectedInterest(projectInterest);
				schedule.setPayment(Math.round((principalAmount + paymentAmount) *100.0)/100.0);
			Date date = new Date();
			if(cal.getTime().equals(date) || cal.getTime().after(date)) {
				schedule.setPaymentStatus(CommonConstant.AWAITINGPAYMENT);
			}
			else {
				schedule.setPaymentStatus(CommonConstant.PROJECTED);
			}
			savePaymentSchedule(schedule);
			LoanProjectLogger.logInfo(getClass(), CommonConstant.PAYMENT_SCHEDULED_DONE);
			paymentScheduleList.add(schedule);
		}
	}
	
	
	public int getDateDifference(String startdate, String endDate) throws ParseException {
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(format.parse(startdate));
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(format.parse(endDate));

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		return diffMonth;
	}
	
	@Override
	public List<LoanDetails> getAllLoansByCustomer(int customerId){
		return this.loanDAO.getAllLoansByCustomer(customerId);
	}
	
	@Override
	public PaymentSchedule savePaymentSchedule(PaymentSchedule paymentSchedule) {
		return this.paymentScheduleRepository.save(paymentSchedule);
	}
	
	@Override
	public List<PaymentSchedule> getPaymentScheduleByLoan(int loanDetailsId){
		return this.paymentScheduleRepository.findByLoanDetailsId(loanDetailsId);
	}
}
