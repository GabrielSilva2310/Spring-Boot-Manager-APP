package com.mybusiness.managerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybusiness.managerapp.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	

}
