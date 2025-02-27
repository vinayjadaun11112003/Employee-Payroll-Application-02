package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeeResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    // Injecting EmployeeService using @Autowired

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService service){
        this.employeeService = service;
    }

    // GET Employee
    @GetMapping("/getById/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable Long id) {
        Employee a = employeeService.getEmployeeById(id);
        return new EmployeeResponseDTO(a.getId(),a.getName(),a.getSalary());
    }

    // POST - Add Employee
    @PostMapping("/create")
    public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee a= employeeService.addEmployee( new Employee(employeeRequestDTO.getId() ,employeeRequestDTO.getName(), employeeRequestDTO.getSalary()));
        return new EmployeeResponseDTO(a.getId(),a.getName(),a.getSalary());
    }

    // PUT - Update Employee
    @PutMapping("/update/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id , @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee a= employeeService.updateEmployee(id , new Employee(employeeRequestDTO.getId() , employeeRequestDTO.getName() , employeeRequestDTO.getSalary()));
        return new EmployeeResponseDTO(a.getId(),a.getName(),a.getSalary());
    }

    // DELETE - Delete Employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}