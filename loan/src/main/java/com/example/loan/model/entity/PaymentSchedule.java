package com.example.loan.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int loanDetailsId;
	private String paymentDate;
	private double principal;
	private double projectedInterest;
	private String paymentStatus;
	private double paymentAmount;
	private double payment;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoanDetailsId() {
		return loanDetailsId;
	}
	public void setLoanDetailsId(int loanDetailsId) {
		this.loanDetailsId = loanDetailsId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getProjectedInterest() {
		return projectedInterest;
	}
	public void setProjectedInterest(double projectedInterest) {
		this.projectedInterest = projectedInterest;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	
}
