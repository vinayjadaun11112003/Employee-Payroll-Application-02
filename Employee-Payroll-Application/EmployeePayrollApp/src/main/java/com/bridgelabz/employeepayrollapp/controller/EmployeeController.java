package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeeResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    // Injecting EmployeeService using @Autowired
    @Autowired
    private EmployeeService employeeService;

    // GET Employee
    @GetMapping("/getById/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        log.info("Received GET request for Employee with ID: {}", id);

        // Make a call to getEmployeeById and log the result
        Employee employee = employeeService.getEmployeeById(id);

        log.info("Returning Employee: {}", employee);
        return employee;
    }

    // POST - Add Employee
    @PostMapping("/create")
    public Employee addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        log.debug("Creating a EEmployee  with id {} ", employeeRequestDTO.getId());
        Employee employee = employeeService.addEmployee( new Employee(employeeRequestDTO.getId() ,employeeRequestDTO.getName(), employeeRequestDTO.getSalary()));
        log.info("Successfully employee created {}" , employee);
        return employee;
    }

    // PUT - Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id , @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.updateEmployee(id , new Employee(employeeRequestDTO.getId() , employeeRequestDTO.getName() , employeeRequestDTO.getSalary()));
    }

    // DELETE - Delete Employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}