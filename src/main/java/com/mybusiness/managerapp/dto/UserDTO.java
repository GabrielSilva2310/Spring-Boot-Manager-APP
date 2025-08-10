package com.mybusiness.managerapp.dto;

import com.mybusiness.managerapp.entities.User;

public class UserDTO {
	
	
	
	private Long id;
	private String name;
	private String email;
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
