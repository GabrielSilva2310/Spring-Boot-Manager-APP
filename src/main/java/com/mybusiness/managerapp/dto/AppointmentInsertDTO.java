package com.mybusiness.managerapp.dto;


import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.AppointmentStatus;

public class AppointmentInsertDTO {
	
 	
	private String title;
	private String description;
    private LocalDateTime  dateTime;
	private AppointmentStatus status; 
    private Long clientId;
    private Long userId;
	
    public AppointmentInsertDTO() {
		super();
	}

	public AppointmentInsertDTO(String title, String description, LocalDateTime  dateTime, AppointmentStatus status,
			Long clientId, Long userId) {
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
		this.clientId = clientId;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime  getDateTime() {
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
