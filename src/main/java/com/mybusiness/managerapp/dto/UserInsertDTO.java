package com.mybusiness.managerapp.dto;



import com.mybusiness.managerapp.services.validation.UserInsertValid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@UserInsertValid
public class UserInsertDTO extends UserDTO {
	
	@NotBlank(message = "Password is required!")
	@Size(min = 8, message = "password must have the min 8 characters")
	private String password;

	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}
	
	
	
	

}
