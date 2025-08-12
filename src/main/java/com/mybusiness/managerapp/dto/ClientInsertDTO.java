package com.mybusiness.managerapp.dto;

public class ClientInsertDTO extends ClientDTO {
	
	private Long userId;
	
	public ClientInsertDTO() {
		super();
	}

	public ClientInsertDTO(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}
	
	
	
	
	
	
}
