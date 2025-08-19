package com.mybusiness.managerapp.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.mybusiness.managerapp.controllers.exceptions.FieldMessage;
import com.mybusiness.managerapp.dto.ClientUpdateDTO;
import com.mybusiness.managerapp.dto.UserUpdateDTO;
import com.mybusiness.managerapp.entities.Client;
import com.mybusiness.managerapp.entities.User;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdateValid, ClientUpdateDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public void initialize(ClientUpdateValid ann) {
	}

	@Override
	public boolean isValid(ClientUpdateDTO dto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long userId = Long.parseLong(uriVars.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Client client = repository.findByEmail(dto.getEmail());
		if (client != null && userId != client.getId()) {
			list.add(new FieldMessage("email", "This email already exists"));
		}
		
		Client clientByPhone = repository.findByPhone(dto.getPhone());
		if (clientByPhone != null && userId != clientByPhone.getId()) {
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
