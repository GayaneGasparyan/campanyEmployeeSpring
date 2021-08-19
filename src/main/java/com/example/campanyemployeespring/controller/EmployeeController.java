package com.example.campanyemployeespring.controller;

import com.example.campanyemployeespring.model.Company;
import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.repository.CompanyRepository;
import com.example.campanyemployeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/employees")
    public String employees(ModelMap modelMap) {
        List<Employee> all = employeeRepository.findAll();
        modelMap.addAttribute("employees", all);
        List<Company> all1 = companyRepository.findAll();
        modelMap.addAttribute("companies",all1);
        return "employees";

    }

    @GetMapping("/addEmployee")
    public String addEmployee( ModelMap modelMap) {
        List<Company> all1 = companyRepository.findAll();
        modelMap.addAttribute("companies",all1);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployeePost(@ModelAttribute Employee employee) {

        employeeRepository.save(employee);
        return "redirect:/employees";
    }


}
