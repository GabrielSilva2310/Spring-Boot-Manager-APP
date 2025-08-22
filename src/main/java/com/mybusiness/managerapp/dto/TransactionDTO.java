package com.mybusiness.managerapp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.entities.Transaction;
import com.mybusiness.managerapp.enums.TransactionType;

public class TransactionDTO {

	private Long id;
	private BigDecimal amount;
	private TransactionType type;
	private String description;
	private Instant dueDate;
	private Boolean paid;
	private Instant createdAt;
	private UserDTO user;
	private ClientMinDTO client;
	
	public TransactionDTO() {
	}

	public TransactionDTO(Long id, BigDecimal amount, TransactionType type, String description, Instant dueDate,
			Boolean paid, Instant createdAt, UserDTO user, ClientMinDTO client) {
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.dueDate = dueDate;
		this.paid = paid;
		this.createdAt = createdAt;
		this.user = user;
		this.client = client;
	}

	public TransactionDTO(Transaction entity) {
		id = entity.getId();
		amount = entity.getAmount();
		type = entity.getType();
		description = entity.getDescription();
		dueDate = entity.getDueDate();
		paid = entity.getPaid();
		createdAt = entity.getCreatedAt();
		user = new UserDTO(entity.getUser());
		client = new ClientMinDTO(entity.getClient());
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

	public Instant getDueDate() {
		return dueDate;
	}

	public Boolean getPaid() {
		return paid;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public UserDTO getUser() {
		return user;
	}

	public ClientMinDTO getClient() {
		return client;
	}
	
	
	
	
	
	

}
