package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;

import com.mybusiness.managerapp.enums.BudgetStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class BudgetUpdateDTO {

	@NotBlank(message = "Description is required!")
	@Size(min = 3, max = 150, message = "Description must be between 3 and 150 characters long")
	private String description;
	
	@NotNull(message = "Total amount is required!")
	@Positive(message = "Total amount must be greater than zero")
	private BigDecimal totalAmount;
	
	@NotNull(message = "Status is required!")
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
