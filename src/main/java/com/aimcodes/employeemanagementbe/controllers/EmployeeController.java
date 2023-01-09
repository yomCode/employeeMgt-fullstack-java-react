package com.aimcodes.employeemanagementbe.controllers;


import com.aimcodes.employeemanagementbe.entites.Employee;
import com.aimcodes.employeemanagementbe.pojos.requests.AddEmployeeRequest;
import com.aimcodes.employeemanagementbe.pojos.requests.UpdateEmployeeRequest;
import com.aimcodes.employeemanagementbe.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody AddEmployeeRequest request){
        return new ResponseEntity<>(employeeService.addEmployee(request), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> viewEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.viewEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request){
        return new ResponseEntity<>(employeeService.updateEmployee(id,request), HttpStatus.OK);
    }

}
