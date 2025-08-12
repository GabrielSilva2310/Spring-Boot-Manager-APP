package com.mybusiness.managerapp.services;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybusiness.managerapp.dto.ClientDTO;
import com.mybusiness.managerapp.dto.ClientInsertDTO;
import com.mybusiness.managerapp.dto.ClientUpdateDTO;
import com.mybusiness.managerapp.entities.Client;
import com.mybusiness.managerapp.entities.User;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.UserRepository;
import com.mybusiness.managerapp.services.exceptions.DataBaseException;
import com.mybusiness.managerapp.services.exceptions.ResourceNotFoundException;


import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}

	@Transactional
	public ClientDTO insert(ClientInsertDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto, entity);
		entity.setCreatedAt(Instant.now());
		entity = repository.save(entity);
		return new ClientDTO(entity);

	}
	
	@Transactional
	public ClientDTO update(Long id, ClientUpdateDTO dto) {
		try {
			Client entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setPhone(dto.getPhone());
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Falha de Integridade Referencial!");
		}
	
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {

		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setUser(userRepository.getReferenceById(dto.getUser().getId()));
		
	}
	
	
}
