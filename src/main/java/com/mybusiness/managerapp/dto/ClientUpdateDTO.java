package com.mybusiness.managerapp.dto;

import com.mybusiness.managerapp.services.validation.ClientUpdateValid;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@ClientUpdateValid
public class ClientUpdateDTO {

	@NotBlank(message = "Name is required!")
	@Size(min = 3, max = 70, message = "Name must be between 3 and 70 characters long")
	private String name;

	@NotBlank(message = "Email is required!")
	@Email(message = "Please provide a valid email address")
	private String email;
	
	@Pattern(regexp = "^\\+?\\d{1,3}[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{4,5}[-.\\s]?\\d{4}$|^\\d{8,11}$", message = "Please provide a valid phone number")
	private String phone;

	public ClientUpdateDTO() {
		super();
	}

	public ClientUpdateDTO(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
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

}
