package com.example.campanyemployeespring.repository;

import com.example.campanyemployeespring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee deleteAllByCompanyId(int id);


}
