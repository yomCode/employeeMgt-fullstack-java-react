package com.aimcodes.employeemanagementbe.services;

import com.aimcodes.employeemanagementbe.entites.Employee;
import com.aimcodes.employeemanagementbe.pojos.requests.AddEmployeeRequest;
import com.aimcodes.employeemanagementbe.pojos.requests.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {
    String addEmployee(AddEmployeeRequest request);

    String deleteEmployee(Long id);

    String updateEmployee(Long id, UpdateEmployeeRequest request);

    List<Employee> getEmployees();

    Employee viewEmployee(Long id);
}
