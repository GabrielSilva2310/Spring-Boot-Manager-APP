package com.mybusiness.managerapp.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mybusiness.managerapp.controllers.exceptions.FieldMessage;
import com.mybusiness.managerapp.dto.ClientInsertDTO;
import com.mybusiness.managerapp.dto.UserInsertDTO;
import com.mybusiness.managerapp.entities.Client;
import com.mybusiness.managerapp.entities.User;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientInsertValidator implements ConstraintValidator<ClientInsertValid, ClientInsertDTO> {
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public void initialize(ClientInsertValid ann) {
	}

	@Override
	public boolean isValid(ClientInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Client client = repository.findByEmail(dto.getEmail());
		if (client != null) {
			list.add(new FieldMessage("email", "This email already exists"));
		}
		
		Client clientByPhone = repository.findByPhone(dto.getPhone());
		if (clientByPhone != null) {
			list.add(new FieldMessage("phone", "This phone number already exists"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
