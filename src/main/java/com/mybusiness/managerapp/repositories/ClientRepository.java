package com.mybusiness.managerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybusiness.managerapp.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
