package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.BudgetStatus;

public class BudgetInsertDTO {
	
	private Long id;
	private String description;
	private BigDecimal totalAmount;
	private BudgetStatus status;
	private LocalDateTime createdAt;
	private Long clientId;
    private Long userId;
	
    public BudgetInsertDTO() {
	}

	public BudgetInsertDTO(Long id, String description, BigDecimal totalAmount, BudgetStatus status, LocalDateTime createdAt,
			Long clientId, Long userId) {
		this.id = id;
		this.description = description;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdAt = createdAt;
		this.clientId = clientId;
		this.userId = userId;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Long getClientId() {
		return clientId;
	}

	public Long getUserId() {
		return userId;
	}
	
	
    
    
    
    
    

}
