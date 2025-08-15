package com.mybusiness.managerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybusiness.managerapp.entities.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
