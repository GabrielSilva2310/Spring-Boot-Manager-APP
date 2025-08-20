package com.mybusiness.managerapp.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import com.mybusiness.managerapp.enums.AppointmentStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AppointmentUpdateDTO {

	@NotBlank(message = "Description is required!")
	@Size(min = 3, max = 150, message = "Description must be between 3 and 150 characters long")
	private String description;
	
	@NotNull(message = "Date and time is required!")
	@Future(message = "Date must be in the future")
	private Instant dateTime;
	
	@NotNull(message = "Status is required!")
	private AppointmentStatus status;

	public AppointmentUpdateDTO() {
		super();
	}

	public AppointmentUpdateDTO(String description, Instant dateTime, AppointmentStatus status) {
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
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

}
