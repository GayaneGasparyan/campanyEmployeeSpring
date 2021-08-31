package com.example.campanyemployeespring.repository;

import com.example.campanyemployeespring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);

  List<Employee> findEmployeeByCompanyId(int Company);


    void deleteAllByCompanyId(int id);

}
