package com.example.campanyemployeespring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int salary;
    private String position;
    private String password;
    @ManyToOne
    private Company company;
    @Enumerated(value = EnumType.STRING)
    @JoinColumn(name = "employee_type")
    private EmployeeType employeeType;

}
