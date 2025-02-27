package com.bridgelabz.employeepayrollapp.service;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        // Add employee to the list
        employeeList.add(employee);
        return employee;
    }

    public Employee getEmployeeById(Long id) {
        // Find the employee with the given ID
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
        return employee.orElse(null); // Return employee if found, otherwise return null
    }

    public List<Employee> getAllEmployees() {
        return employeeList; // Return all employees in the list
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employeeList.set(i, updatedEmployee); // Update employee details
                return updatedEmployee;
            }
        }
        // Return null if no matching employee is found
        return null;
    }

    public boolean deleteEmployee(Long id) {
        // Remove employee with the given ID
        return employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}