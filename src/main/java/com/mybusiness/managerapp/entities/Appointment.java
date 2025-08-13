package com.mybusiness.managerapp.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import com.mybusiness.managerapp.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_appointment" )
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime dateTime;
	private AppointmentStatus status; 
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;


	public Appointment() {
	}


	public Appointment(Long id, String title, String description, LocalDateTime dateTime, AppointmentStatus status,
			User user, Client client) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
		this.user = user;
		this.client = client;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime  getDateTime() {
		return dateTime;
	}


	public void setDateTime(LocalDateTime  dateTime) {
		this.dateTime = dateTime;
	}


	public AppointmentStatus getStatus() {
		return status;
	}


	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Long getId() {
		return id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	

}
