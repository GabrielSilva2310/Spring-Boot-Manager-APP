package com.mybusiness.managerapp.dto;


import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.AppointmentStatus;

public class AppointmentUpdateDTO {
	
	 private String description;
	 private LocalDateTime  dateTime;
	 private AppointmentStatus status;
	
	 public AppointmentUpdateDTO() {
		super();
	 }

	 public AppointmentUpdateDTO(String description, LocalDateTime  dateTime, AppointmentStatus status) {
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
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
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
