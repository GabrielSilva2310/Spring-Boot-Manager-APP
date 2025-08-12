package com.mybusiness.managerapp.dto;

public class ClientUpdateDTO {
	
	
	   private String name;
	   private String email;
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
