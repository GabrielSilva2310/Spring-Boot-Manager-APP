package com.mybusiness.managerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybusiness.managerapp.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByEmail(String email);

}
