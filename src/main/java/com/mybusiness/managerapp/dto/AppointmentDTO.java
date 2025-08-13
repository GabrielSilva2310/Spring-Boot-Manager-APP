package com.mybusiness.managerapp.dto;


import java.time.LocalDateTime;

import com.mybusiness.managerapp.entities.Appointment;
import com.mybusiness.managerapp.enums.AppointmentStatus;

public class AppointmentDTO {
	
	   private Long id;
	   	
	   private String title;
	   private String description;
	   private LocalDateTime  dateTime;
	   private AppointmentStatus status; 
	   private ClientMinDTO client;
	   private UserDTO user;
	
	   public AppointmentDTO() {
	   }

	   

	  public AppointmentDTO(Long id, String title, String description, LocalDateTime  dateTime, AppointmentStatus status,
			  ClientMinDTO client, UserDTO user) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
		this.client = client;
		this.user = user;
	  }



	  public AppointmentDTO(Appointment entity) {
		id = entity.getId();
		title = entity.getTitle();
		description = entity.getDescription();
		dateTime = entity.getDateTime();
		status = entity.getStatus();
		client = new ClientMinDTO(entity.getClient());
		user = new UserDTO(entity.getUser());
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



	public LocalDateTime  getDateTime() {
		return dateTime;
	}



	public AppointmentStatus getStatus() {
		return status;
	}



	public ClientMinDTO getClient() {
		return client;
	}



	public UserDTO getUser() {
		return user;
	}
	  
	  
	  
	  


	   
	   
	   
	
	   
	   
	   
	   
	   
	   
	   
    
}