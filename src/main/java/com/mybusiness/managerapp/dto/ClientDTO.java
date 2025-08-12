package com.mybusiness.managerapp.dto;

import java.time.Instant;

import com.mybusiness.managerapp.entities.Client;


public class ClientDTO {
	
	 private Long id;
	 private String name;
	 private String email;
	 private String phone;
	 private UserDTO user;
	
	 public ClientDTO() {
	 }

	 public ClientDTO(Long id, String name, String email, String phone, Instant createdAt, UserDTO user) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	
		this.user = user;
	 }
	 
	 public ClientDTO(Client entity) {
			id = entity.getId();
			name = entity.getName();
			email = entity.getEmail();
			phone = entity.getPhone();
			user = new UserDTO(entity.getUser());
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

	public String getPhone() {
		return phone;
	}


	public UserDTO getUser() {
		return user;
	}
	 
	 
	 
	 

	 
	 
	 
}
