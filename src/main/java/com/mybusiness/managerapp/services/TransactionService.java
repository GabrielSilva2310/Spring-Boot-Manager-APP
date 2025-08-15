package com.mybusiness.managerapp.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybusiness.managerapp.dto.TransactionDTO;
import com.mybusiness.managerapp.dto.TransactionInsertDTO;
import com.mybusiness.managerapp.dto.TransactionUpdateDTO;
import com.mybusiness.managerapp.entities.Transaction;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.TransactionRepository;
import com.mybusiness.managerapp.repositories.UserRepository;
import com.mybusiness.managerapp.services.exceptions.ResourceNotFoundException;


import jakarta.persistence.EntityNotFoundException;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public TransactionDTO findById(Long id) {
		Transaction transaction = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		return new TransactionDTO(transaction);
	}

	@Transactional(readOnly = true)
	public Page<TransactionDTO> findAllPaged(Pageable pageable) {
		Page<Transaction> result = repository.findAll(pageable);
		return result.map(x -> new TransactionDTO(x));
	}

	@Transactional
	public TransactionDTO insert(TransactionInsertDTO dto) {
		Transaction entity = new Transaction();
		entity.setAmount(dto.getAmount());
		entity.setType(dto.getType());
		entity.setDescription(dto.getDescription());
		entity.setDueDate(dto.getDueDate());
		entity.setPaid(false);
		entity.setCreatedAt(LocalDateTime.now());
		entity.setClient(clientRepository.getReferenceById(dto.getClientId()));
		entity.setUser(userRepository.getReferenceById(dto.getUserId()));
		entity = repository.save(entity);
		return new TransactionDTO(entity);

	}
	
	@Transactional
	public TransactionDTO update(Long id, TransactionUpdateDTO dto) {
		try {
			Transaction entity = repository.getReferenceById(id);
			entity.setAmount(dto.getAmount());
			entity.setType(dto.getType());
			entity.setDescription(dto.getDescription());
			entity.setDueDate(dto.getDueDate());
			entity.setPaid(dto.getPaid());
			entity = repository.save(entity);
			return new TransactionDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	
}
