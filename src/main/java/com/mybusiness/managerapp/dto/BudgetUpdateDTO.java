package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;

import com.mybusiness.managerapp.enums.BudgetStatus;

public class BudgetUpdateDTO {

	private String description;
	private BigDecimal totalAmount;
	private BudgetStatus status;
	
	public BudgetUpdateDTO() {
	}

	public BudgetUpdateDTO(String description, BigDecimal totalAmount, BudgetStatus status) {
		this.description = description;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public BudgetStatus getStatus() {
		return status;
	}
	
	
	
	
	

}
