package com.mybusiness.managerapp.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.mybusiness.managerapp.dto.ContractDTO;
import com.mybusiness.managerapp.dto.ContractInsertDTO;
import com.mybusiness.managerapp.dto.ContractUpdateDTO;
import com.mybusiness.managerapp.dto.TransactionDTO;
import com.mybusiness.managerapp.dto.TransactionInsertDTO;
import com.mybusiness.managerapp.dto.TransactionUpdateDTO;
import com.mybusiness.managerapp.services.ContractService;
import com.mybusiness.managerapp.services.TransactionService;



@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping
	public ResponseEntity<Page<TransactionDTO>> findAll(Pageable pageable) {
		Page<TransactionDTO> page = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TransactionDTO> findById(@PathVariable Long id) {
		TransactionDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<TransactionDTO> insert(@RequestBody TransactionInsertDTO dto) {
		TransactionDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TransactionDTO> update(@PathVariable Long id, @RequestBody TransactionUpdateDTO dto) {
		TransactionDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}


} 