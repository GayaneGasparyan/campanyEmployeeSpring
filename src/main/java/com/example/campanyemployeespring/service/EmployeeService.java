package com.example.campanyemployeespring.service;

import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.repository.EmployeeRepository;
import com.example.campanyemployeespring.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TopicRepository topicRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public List<Employee> findEmployeeByCompanyId(int companyId) {
        return employeeRepository.findEmployeeByCompanyId(companyId);
    }

    public void deleteAllByCompanyId(int id) {
        employeeRepository.deleteAllByCompanyId(id);

    }

    public Optional<Employee> findEmployeeById(int id) {

        return employeeRepository.findById(id);

    }


    public void deleteTopicByEmployeeId(int id) {

        topicRepository.deleteTopicByEmployee_Id(id);


    }
}


