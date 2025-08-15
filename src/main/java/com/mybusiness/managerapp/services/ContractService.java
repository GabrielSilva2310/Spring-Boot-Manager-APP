package com.mybusiness.managerapp.services;




import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybusiness.managerapp.dto.BudgetDTO;
import com.mybusiness.managerapp.dto.BudgetInsertDTO;
import com.mybusiness.managerapp.dto.BudgetUpdateDTO;
import com.mybusiness.managerapp.dto.ContractDTO;
import com.mybusiness.managerapp.dto.ContractInsertDTO;
import com.mybusiness.managerapp.dto.ContractUpdateDTO;
import com.mybusiness.managerapp.entities.Budget;
import com.mybusiness.managerapp.entities.Contract;
import com.mybusiness.managerapp.enums.BudgetStatus;
import com.mybusiness.managerapp.repositories.BudgetRepository;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.ContractRepository;
import com.mybusiness.managerapp.repositories.UserRepository;
import com.mybusiness.managerapp.services.exceptions.DataBaseException;
import com.mybusiness.managerapp.services.exceptions.ResourceNotFoundException;


import jakarta.persistence.EntityNotFoundException;

@Service
public class ContractService {
	
	@Autowired
	private ContractRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public ContractDTO findById(Long id) {
		Contract contract = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		return new ContractDTO(contract);
	}

	@Transactional(readOnly = true)
	public Page<ContractDTO> findAllPaged(Pageable pageable) {
		Page<Contract> result = repository.findAll(pageable);
		return result.map(x -> new ContractDTO(x));
	}

	@Transactional
	public ContractDTO insert(ContractInsertDTO dto) {
		Contract entity = new Contract();
		entity.setTitle(dto.getTitle());
		entity.setFileUrl(dto.getFileUrl());
		entity.setSigned(dto.getSigned());
		entity.setCreatedAt(LocalDateTime.now());
		entity.setClient(clientRepository.getReferenceById(dto.getClientId()));
		entity.setUser(userRepository.getReferenceById(dto.getUserId()));
		entity = repository.save(entity);
		return new ContractDTO(entity);

	}
	
	@Transactional
	public ContractDTO update(Long id, ContractUpdateDTO dto) {
		try {
			Contract entity = repository.getReferenceById(id);
			entity.setTitle(dto.getTitle());
			entity.setFileUrl(dto.getFileUrl());
			entity.setSigned(dto.getSigned());
			entity = repository.save(entity);
			return new ContractDTO(entity);
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
	
	
}
