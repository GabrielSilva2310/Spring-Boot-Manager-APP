package com.mybusiness.managerapp.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContractInsertDTO {
	
	private Long id;
	
	@NotBlank(message = "Title is required!")
	@Size(min = 3, max = 70, message = "Title must be between 3 and 70 characters long")
	private String title;
	
	@NotBlank(message = "FileUrl is required!")
	private String fileUrl; 
	
	private Boolean signed;
	private LocalDateTime createdAt;
	
	@NotNull(message = "UserId is required!")
	private Long userId;
	
	@NotNull(message = "ClientId is required!")
	private Long clientId;
	
	public ContractInsertDTO() {
	}

	public ContractInsertDTO(Long id, String title, String fileUrl, Boolean signed, LocalDateTime createdAt, Long userId,
			Long clientId) {
		this.id = id;
		this.title = title;
		this.fileUrl = fileUrl;
		this.signed = signed;
		this.createdAt = createdAt;
		this.userId = userId;
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public Boolean getSigned() {
		return signed;
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
