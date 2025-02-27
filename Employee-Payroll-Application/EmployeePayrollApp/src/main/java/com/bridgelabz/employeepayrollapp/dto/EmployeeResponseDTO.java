package com.bridgelabz.employeepayrollapp.dto;

//DTO (Data Transfer Object) used to send employee details as a response.
public class EmployeeResponseDTO{
    // Employee's name
    private String name;
    // Employee's salary
    private double salary;

    // Default Constructor for mapper
    public EmployeeResponseDTO() {
    }

    // Parameterized Constructor to initialize the employee details
    public EmployeeResponseDTO( String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Getter and Setter for 'salary'
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
