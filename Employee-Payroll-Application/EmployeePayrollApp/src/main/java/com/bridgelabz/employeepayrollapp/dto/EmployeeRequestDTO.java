package com.bridgelabz.employeepayrollapp.dto;

import lombok.*;

// DTO (Data Transfer Object) for Employee requests.
// This class is used to transfer employee details from the client to the server.
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequestDTO {
    // Data members for the employee details. (id, name, salary)
    // Used lombok annotations to generate getters, setters, toString, constructor, etc.
    private Long id;
    private String name;
    private double salary;

}