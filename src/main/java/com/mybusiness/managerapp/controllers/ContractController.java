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
import com.mybusiness.managerapp.services.ContractService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

	@Autowired
	private ContractService service;
	
	@GetMapping
	public ResponseEntity<Page<ContractDTO>> findAll(Pageable pageable) {
		Page<ContractDTO> page = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ContractDTO> findById(@PathVariable Long id) {
		ContractDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<ContractDTO> insert(@RequestBody @Valid ContractInsertDTO dto) {
		ContractDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ContractDTO> update(@PathVariable Long id, @RequestBody @Valid ContractUpdateDTO dto) {
		ContractDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
} 