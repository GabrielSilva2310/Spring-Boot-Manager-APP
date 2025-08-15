package com.mybusiness.managerapp.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public class ContractInsertDTO {
	
	private Long id;
	private String title;
	private String fileUrl; 
	private Boolean signed;
	private LocalDateTime createdAt;
	private Long userId;
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
