package com.bridgelabz.employeepayrollapp.controller;
import com.bridgelabz.employeepayrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeeResponseDTO;
import org.springframework.web.bind.annotation.*;

// RestController to send the response
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    // Create a controller to GET employee
    @GetMapping("/get")
    public EmployeeResponseDTO getEmployee() {
        return new EmployeeResponseDTO("Ankit" , 45000);
    }

    // addEmployee method to add the Employee
    @PostMapping("/create")
    public EmployeeResponseDTO  addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new EmployeeResponseDTO(employeeRequestDTO.getName(), employeeRequestDTO.getSalary());
    }

    // PUT - Update employee by ID in existing database
    @PutMapping("/update/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id,
                                              @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        // Logic to update the employee with new details
        return new EmployeeResponseDTO(employeeRequestDTO.getName(), employeeRequestDTO.getSalary());
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        // Logic to delete the employee from the database
        return "Employee with ID " + id + " deleted successfully!";
    }

}