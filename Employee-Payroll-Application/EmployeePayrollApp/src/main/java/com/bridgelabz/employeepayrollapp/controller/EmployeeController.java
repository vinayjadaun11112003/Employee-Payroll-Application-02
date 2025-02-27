package com.bridgelabz.employeepayrollapp.controller;
import org.springframework.web.bind.annotation.*;

// RestController to send the response
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    // Create a controller to GET employee
    @GetMapping("/get")
    public String getEmployee() {
        return "Get Employee for returning the Employee Details";
    }

    // addEmployee method to add the Employee
    @PostMapping("/create")
    public String addEmployee(@RequestParam String name , @RequestParam Long salary) {
        return "Employee Name is "+ name + " and his salary is "+ salary;
    }

    // PUT - Update employee by ID in existing database
    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id) {
        return "Updating the Employee his id equal to "+ id;
    }

    // DELETE - Delete employee by ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return "Employee with ID " + id + " deleted successfully!";
    }
}