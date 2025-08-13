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

import com.mybusiness.managerapp.dto.AppointmentDTO;
import com.mybusiness.managerapp.dto.AppointmentInsertDTO;
import com.mybusiness.managerapp.dto.AppointmentUpdateDTO;
import com.mybusiness.managerapp.dto.ClientDTO;
import com.mybusiness.managerapp.dto.ClientInsertDTO;
import com.mybusiness.managerapp.dto.ClientUpdateDTO;
import com.mybusiness.managerapp.services.AppointmentService;
import com.mybusiness.managerapp.services.ClientService;


@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@GetMapping
	public ResponseEntity<Page<AppointmentDTO>> findAll(Pageable pageable) {
		Page<AppointmentDTO> page = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id) {
		AppointmentDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<AppointmentDTO> insert(@RequestBody AppointmentInsertDTO dto) {
		AppointmentDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentUpdateDTO dto) {
		AppointmentDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
} 