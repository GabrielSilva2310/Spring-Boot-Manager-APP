package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.TransactionType;

public class TransactionUpdateDTO {

	private BigDecimal amount;
	private TransactionType type;
	private String description;
	private LocalDateTime dueDate;
	private Boolean paid;
	
	public TransactionUpdateDTO() {
	}

	public TransactionUpdateDTO(BigDecimal amount, TransactionType type, String description, LocalDateTime dueDate,
			Boolean paid) {
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.dueDate = dueDate;
		this.paid = paid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public TransactionType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public Boolean getPaid() {
		return paid;
	}
	
	
	
	
	

}
