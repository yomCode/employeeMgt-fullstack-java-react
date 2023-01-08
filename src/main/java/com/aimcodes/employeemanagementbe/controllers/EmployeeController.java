package com.aimcodes.employeemanagementbe.controllers;


import com.aimcodes.employeemanagementbe.entites.Employee;
import com.aimcodes.employeemanagementbe.pojos.requests.AddEmployeeRequest;
import com.aimcodes.employeemanagementbe.pojos.requests.UpdateEmployeeRequest;
import com.aimcodes.employeemanagementbe.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/employees")
    public String addEmployee(@RequestBody AddEmployeeRequest request){
        return employeeService.addEmployee(request);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee viewEmployee(@PathVariable Long id){
        return employeeService.viewEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request){
        return employeeService.updateEmployee(id,request);
    }

}
