package com.aimcodes.employeemanagementbe.services.serviceImpl;

import com.aimcodes.employeemanagementbe.entites.Employee;
import com.aimcodes.employeemanagementbe.pojos.requests.AddEmployeeRequest;
import com.aimcodes.employeemanagementbe.pojos.requests.UpdateEmployeeRequest;
import com.aimcodes.employeemanagementbe.repositories.EmployeeRepository;
import com.aimcodes.employeemanagementbe.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(AddEmployeeRequest request){

        Boolean existingEmployee = employeeRepository.existsByEmail(request.getEmail());

        if(!existingEmployee) {
            Employee employee = Employee.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .build();
            employeeRepository.save(employee);
            return "Employee added successfully";
        }

        return "Employee already exists";
    }

    @Override
    public String deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow();

        employeeRepository.delete(employee);

        return "Employee deleted successfully";
    }


    @Override
    public String updateEmployee(Long id, UpdateEmployeeRequest request){
        Employee employee = employeeRepository.findById(id).orElseThrow();

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());

        employeeRepository.save(employee);

        return "Details saved";
    }

    @Override
    public List<Employee> getEmployees(){

        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    @Override
    public Employee viewEmployee(Long id){
       Employee employee = employeeRepository.findById(id).orElseThrow();

       return employee;
    }

}
