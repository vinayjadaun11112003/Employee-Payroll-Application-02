package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {

        log.debug("Creating a Employee With Name :{}", employee.getName());
        // Add employee to the list
        employeeList.add(employee);

        log.info("Successfully a employee Created {}", employee);
        return employee;
    }

    public Employee getEmployeeById(Long id) {
        log.debug("Searching for Employee By Id {}" , id);

        // Find the employee with the given ID
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();

        // Return employee if found, otherwise return null
        return employee.orElse(null);
    }

    public List<Employee> getAllEmployees() {

        // Return all employees in the list
        return employeeList;
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        log.debug("Updating the Employee Whose id is {}" , id);
        // Find the employee with the given ID and update their details
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                // Update employee details
                employeeList.set(i, updatedEmployee);

                log.info("Successfully Employee Details Updated ......");
                return updatedEmployee;
            }
        }
        log.warn("No Employee Found With Id {} please check again...." , id);
        // Return null if no matching employee is found
        return null;
    }

    public boolean deleteEmployee(Long id) {
        log.debug("Deleting the Employee Whose id is {}" , id);
        // Remove employee with the given ID
        return employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}