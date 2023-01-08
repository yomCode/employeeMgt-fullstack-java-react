package com.aimcodes.employeemanagementbe.repositories;


import com.aimcodes.employeemanagementbe.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Boolean existsByEmail(String email);
}


