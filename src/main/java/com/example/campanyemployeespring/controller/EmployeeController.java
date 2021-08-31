package com.example.campanyemployeespring.controller;

import com.example.campanyemployeespring.model.Company;
import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.repository.CompanyRepository;
import com.example.campanyemployeespring.repository.EmployeeRepository;
import com.example.campanyemployeespring.security.CurrentUser;
import com.example.campanyemployeespring.service.CompanyService;
import com.example.campanyemployeespring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    private CompanyService companyService;

    private PasswordEncoder passwordEncoder;

    @GetMapping("/employees")
    public String employees(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Employee> all = employeeService.findEmployeeByCompanyId(currentUser.getEmployee().getId());
        modelMap.addAttribute("employees", all);
        companyService.findAll();

        return "employees";

    }

    @GetMapping("/addEmployee")
    public String addEmployee(ModelMap modelMap) {
        List<Company> all1 = companyService.findAll();
        modelMap.addAttribute("companies", all1);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployeePost(@ModelAttribute Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.save(employee);
        Company compById = companyService.getById(employee.getCompany().getId());
        compById.setSize(compById.getSize() + 1);
        companyService.save(compById);
        return "redirect:/employees";
    }


}
