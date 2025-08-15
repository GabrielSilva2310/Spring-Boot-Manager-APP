package com.mybusiness.managerapp.dto;

public class ContractUpdateDTO {

	private String title;
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
