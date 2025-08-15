package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.TransactionType;

public class TransactionInsertDTO {
	
	private Long id;
	private BigDecimal amount;
	private TransactionType type;
	private String description;
	private LocalDateTime dueDate;
	private Boolean paid;
	private LocalDateTime createdAt;
	private Long userId;
	private Long clientId;
	
	public TransactionInsertDTO() {
	}

	public TransactionInsertDTO(Long id, BigDecimal amount, TransactionType type, String description, LocalDateTime dueDate,
			Boolean paid, LocalDateTime createdAt, Long userId, Long clientId) {
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.dueDate = dueDate;
		this.paid = paid;
		this.createdAt = createdAt;
		this.userId = userId;
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getClientId() {
		return clientId;
	}
	
	
	
	
	
	
	

}
