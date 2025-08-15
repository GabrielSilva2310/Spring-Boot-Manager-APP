package com.mybusiness.managerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybusiness.managerapp.entities.Contract;


@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

}
