package com.mybusiness.managerapp.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.entities.Contract;

public class ContractDTO {
	
    private Long id;
	private String title;
	private String fileUrl; 
	private Boolean signed;
	private Instant createdAt;
	private UserDTO user;
	private ClientMinDTO client;
	
	public ContractDTO() {
	}

	public ContractDTO(Long id, String title, String fileUrl, Boolean signed, Instant createdAt, UserDTO user,
			ClientMinDTO client) {
		this.id = id;
		this.title = title;
		this.fileUrl = fileUrl;
		this.signed = signed;
		this.createdAt = createdAt;
		this.user = user;
		this.client = client;
	}

	public ContractDTO(Contract entity) {
		id = entity.getId();
		title = entity.getTitle();
		fileUrl = entity.getFileUrl();
		signed = entity.getSigned();
		createdAt = entity.getCreatedAt();
		user = new UserDTO(entity.getUser());
		client = new ClientMinDTO(entity.getClient());
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
