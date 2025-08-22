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


import com.mybusiness.managerapp.dto.BudgetDTO;
import com.mybusiness.managerapp.dto.BudgetInsertDTO;
import com.mybusiness.managerapp.dto.BudgetUpdateDTO;
import com.mybusiness.managerapp.services.BudgetService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/budgets")
public class BudgetController {

	@Autowired
	private BudgetService service;
	
	@GetMapping
	public ResponseEntity<Page<BudgetDTO>> findAll(Pageable pageable) {
		Page<BudgetDTO> page = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<BudgetDTO> findById(@PathVariable Long id) {
		BudgetDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<BudgetDTO> insert(@RequestBody @Valid BudgetInsertDTO dto) {
		BudgetDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<BudgetDTO> update(@PathVariable Long id, @RequestBody @Valid BudgetUpdateDTO dto) {
		BudgetDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
} 