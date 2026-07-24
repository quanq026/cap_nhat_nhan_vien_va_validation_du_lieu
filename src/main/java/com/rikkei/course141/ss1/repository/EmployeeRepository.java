package com.rikkei.course141.ss1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikkei.course141.ss1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
