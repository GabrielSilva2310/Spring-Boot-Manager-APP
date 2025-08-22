package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.BudgetStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class BudgetInsertDTO {
	
	private Long id;
	
	@NotBlank(message = "Description is required!")
	@Size(min = 3, max = 150, message = "Description must be between 3 and 150 characters long")
	private String description;
	
	@NotNull(message = "Total amount is required!")
	@Positive(message = "Total amount must be greater than zero")
	private BigDecimal totalAmount;
	
	private BudgetStatus status;
	private Instant createdAt;
	
	@NotNull(message = "ClientId is required!")
    private Long clientId;
	
	@NotNull(message = "UserId is required!")
    private Long userId;
	
    public BudgetInsertDTO() {
	}

	public BudgetInsertDTO(Long id, String description, BigDecimal totalAmount, BudgetStatus status, Instant createdAt,
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Long getClientId() {
		return clientId;
	}

	public Long getUserId() {
		return userId;
	}
	
	
    
    
    
    
    

}
