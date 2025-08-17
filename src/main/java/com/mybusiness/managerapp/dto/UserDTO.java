package com.mybusiness.managerapp.dto;

import com.mybusiness.managerapp.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserDTO {
	
	private Long id;
	
	@NotBlank(message = "Name is required!")
	@Size(min = 3, max = 70, message = "Name must be between 3 and 70 characters long")
	private String name;
	
	@NotBlank(message = "Email is required!")
	@Email(message = "Please provide a valid email address")
	private String email;
	
	@NotBlank(message = "Bussiness Name is required!")
	@Size(min = 3, max = 90, message = "Name must be between 3 and 90 characters long")
	private String businessName;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String businessName) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.businessName = businessName;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		businessName = entity.getBusinessName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getBusinessName() {
		return businessName;
	}
	
	
	
	
	
	
	 

}
