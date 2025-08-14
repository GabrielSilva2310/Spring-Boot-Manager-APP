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
import com.mybusiness.managerapp.entities.Budget;
import com.mybusiness.managerapp.enums.BudgetStatus;
import com.mybusiness.managerapp.repositories.BudgetRepository;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.UserRepository;
import com.mybusiness.managerapp.services.exceptions.DataBaseException;
import com.mybusiness.managerapp.services.exceptions.ResourceNotFoundException;


import jakarta.persistence.EntityNotFoundException;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public BudgetDTO findById(Long id) {
		Budget budget = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		return new BudgetDTO(budget);
	}

	@Transactional(readOnly = true)
	public Page<BudgetDTO> findAllPaged(Pageable pageable) {
		Page<Budget> result = repository.findAll(pageable);
		return result.map(x -> new BudgetDTO(x));
	}

	@Transactional
	public BudgetDTO insert(BudgetInsertDTO dto) {
		Budget entity = new Budget();
		entity.setDescription(dto.getDescription());
		entity.setTotalAmount(dto.getTotalAmount());
		entity.setStatus(BudgetStatus.PENDING);
		entity.setCreatedAt(LocalDateTime.now());
		entity.setClient(clientRepository.getReferenceById(dto.getClientId()));
		entity.setUser(userRepository.getReferenceById(dto.getUserId()));
		entity = repository.save(entity);
		return new BudgetDTO(entity);

	}
	
	@Transactional
	public BudgetDTO update(Long id, BudgetUpdateDTO dto) {
		try {
			Budget entity = repository.getReferenceById(id);
			entity.setDescription(dto.getDescription());
			entity.setTotalAmount(dto.getTotalAmount());
			entity.setStatus(dto.getStatus());
			entity = repository.save(entity);
			return new BudgetDTO(entity);
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
