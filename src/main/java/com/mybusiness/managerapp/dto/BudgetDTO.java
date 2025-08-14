package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.entities.Budget;
import com.mybusiness.managerapp.enums.BudgetStatus;

public class BudgetDTO {

	private Long id;
	private String description;
	private BigDecimal totalAmount;
	private BudgetStatus status;
	private LocalDateTime createdAt;
	private UserDTO user;
	private ClientMinDTO client;

	public BudgetDTO() {
	}

	public BudgetDTO(Long id, String description, BigDecimal totalAmount, BudgetStatus status, LocalDateTime createdAt,
			UserDTO user, ClientMinDTO client) {
		this.id = id;
		this.description = description;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdAt = createdAt;
		this.user = user;
		this.client = client;
	}

	public BudgetDTO(Budget entity) {
		id = entity.getId();
		description = entity.getDescription();
		totalAmount = entity.getTotalAmount();
		status = entity.getStatus();
		createdAt = entity.getCreatedAt();
		user = new UserDTO(entity.getUser());
		client = new ClientMinDTO(entity.getClient());
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

	public UserDTO getUser() {
		return user;
	}

	public ClientMinDTO getClient() {
		return client;
	}
	
	
	
	

}
