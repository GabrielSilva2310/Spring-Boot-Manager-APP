package com.mybusiness.managerapp.entities;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user" )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String password;
	private String businessName;
	private Instant createdAt;
	
	@OneToMany(mappedBy = "user")
	private List<Client> clients;

	@OneToMany(mappedBy = "user")
	private List<Appointment> appointments;

	@OneToMany(mappedBy = "user")
	private List<Budget> budgets;

	@OneToMany(mappedBy = "user")
	private List<Contract> contracts;

	@OneToMany(mappedBy = "user")
	private List<Transaction> transactions;
	
	public User() {
	}

	public User(Long id, String name, String email, String password, String businessName, Instant createdAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.businessName = businessName;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	

}
