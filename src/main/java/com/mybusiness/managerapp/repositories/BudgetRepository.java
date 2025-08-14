package com.mybusiness.managerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybusiness.managerapp.entities.Budget;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
