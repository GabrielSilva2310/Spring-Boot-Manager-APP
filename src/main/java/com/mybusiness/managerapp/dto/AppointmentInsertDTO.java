package com.mybusiness.managerapp.dto;


import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.AppointmentStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AppointmentInsertDTO {
	
	private Long id;
	
	@NotBlank(message = "Title is required!")
	@Size(min = 3, max = 70, message = "Title must be between 3 and 70 characters long")
	private String title;
	
	@NotBlank(message = "Description is required!")
	@Size(min = 3, max = 150, message = "Description must be between 3 and 150 characters long")
	private String description;
	
	@NotNull(message = "Date and time is required!")
	@Future(message = "Date must be in the future")
    private Instant dateTime;
	
	private AppointmentStatus status;
	
	@NotNull(message = "ClientId is required!")
    private Long clientId;
	
	@NotNull(message = "UserId is required!")
    private Long userId;
	
    public AppointmentInsertDTO() {
		super();
	}
    
    
	public AppointmentInsertDTO(Long id, String title, String description, Instant dateTime,
			AppointmentStatus status, Long clientId, Long userId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
		this.clientId = clientId;
		this.userId = userId;
	}
	

	public Long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Instant getDateTime() {
		return dateTime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public Long getClientId() {
		return clientId;
	}

	public Long getUserId() {
		return userId;
	}
	
	
    
    
    
    

}
