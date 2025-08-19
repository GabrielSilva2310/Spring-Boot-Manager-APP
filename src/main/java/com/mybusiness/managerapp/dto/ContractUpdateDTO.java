package com.mybusiness.managerapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContractUpdateDTO {

	@NotBlank(message = "Title is required!")
	@Size(min = 3, max = 70, message = "Title must be between 3 and 70 characters long")
	private String title;
	
	@NotBlank(message = "FileUrl is required!")
	private String fileUrl; 
	
	private Boolean signed;

	public ContractUpdateDTO() {
	}
	
	

	public ContractUpdateDTO(String title, String fileUrl, Boolean signed) {
		this.title = title;
		this.fileUrl = fileUrl;
		this.signed = signed;
	}



	public String getTitle() {
		return title;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public Boolean getSigned() {
		return signed;
	}
	
	
	

}
