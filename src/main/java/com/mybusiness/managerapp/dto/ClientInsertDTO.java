package com.mybusiness.managerapp.dto;

import com.mybusiness.managerapp.services.validation.ClientInsertValid;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@ClientInsertValid
public class ClientInsertDTO {

	private Long id;

	@NotBlank(message = "Name is required!")
	@Size(min = 3, max = 70, message = "Name must be between 3 and 70 characters long")
	private String name;

	@NotBlank(message = "Email is required!")
	@Email(message = "Please provide a valid email address")
	private String email;

	@Pattern(regexp = "^\\+?\\d{1,3}[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{4,5}[-.\\s]?\\d{4}$|^\\d{8,11}$", message = "Please provide a valid phone number")
	private String phone;

	@NotNull(message = "UserId is required!")
	private Long userId;

	public ClientInsertDTO() {
	}

	public ClientInsertDTO(Long id, String name, String email, String phone, Long userId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}

}
