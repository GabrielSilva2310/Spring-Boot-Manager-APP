package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.TransactionType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TransactionUpdateDTO {

	@NotNull(message = "Amount is required!")
	@Positive(message = "Amount must be greater than zero")
	private BigDecimal amount;
	
	@NotNull(message = "Type is required")
	private TransactionType type;
	
	@NotBlank(message = "Description is required!")
	@Size(min = 3, max = 150, message = "Description must be between 3 and 150 characters long")
	private String description;
	
	@NotNull(message = "Duedate and time is required!")
	@Future(message = "Duedate must be in the future")
	private Instant dueDate;
	
	@NotNull(message = "Paid is required")
	private Boolean paid;
	
	public TransactionUpdateDTO() {
	}

	public TransactionUpdateDTO(BigDecimal amount, TransactionType type, String description, Instant dueDate,
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

	public Instant getDueDate() {
		return dueDate;
	}

	public Boolean getPaid() {
		return paid;
	}
	
	
	
	
	

}
