package com.mybusiness.managerapp.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybusiness.managerapp.dto.AppointmentDTO;
import com.mybusiness.managerapp.dto.AppointmentInsertDTO;
import com.mybusiness.managerapp.dto.AppointmentUpdateDTO;
import com.mybusiness.managerapp.entities.Appointment;
import com.mybusiness.managerapp.enums.AppointmentStatus;
import com.mybusiness.managerapp.repositories.AppointmentRepository;
import com.mybusiness.managerapp.repositories.ClientRepository;
import com.mybusiness.managerapp.repositories.UserRepository;
import com.mybusiness.managerapp.services.exceptions.DataBaseException;
import com.mybusiness.managerapp.services.exceptions.ResourceNotFoundException;


import jakarta.persistence.EntityNotFoundException;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public AppointmentDTO findById(Long id) {
		Appointment appointment = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		return new AppointmentDTO(appointment);
	}

	@Transactional(readOnly = true)
	public Page<AppointmentDTO> findAllPaged(Pageable pageable) {
		Page<Appointment> result = repository.findAll(pageable);
		return result.map(x -> new AppointmentDTO(x));
	}

	@Transactional
	public AppointmentDTO insert(AppointmentInsertDTO dto) {
		Appointment entity = new Appointment();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setDateTime(dto.getDateTime());
		entity.setStatus(AppointmentStatus.SCHEDULED);
		entity.setClient(clientRepository.getReferenceById(dto.getClientId()));
		entity.setUser(userRepository.getReferenceById(dto.getUserId()));
		entity = repository.save(entity);
		return new AppointmentDTO(entity);

	}
	
	@Transactional
	public AppointmentDTO update(Long id, AppointmentUpdateDTO dto) {
		try {
			Appointment entity = repository.getReferenceById(id);
			entity.setDescription(dto.getDescription());
			entity.setDateTime(dto.getDateTime());
			entity.setStatus(dto.getStatus());
			entity = repository.save(entity);
			return new AppointmentDTO(entity);
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
