package com.example.campanyemployeespring.controller;

import com.example.campanyemployeespring.model.Company;
import com.example.campanyemployeespring.repository.CompanyRepository;
import com.example.campanyemployeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller

public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/companies")

    public String companies(ModelMap modelMap) {
        List<Company> all = companyRepository.findAll();
        modelMap.addAttribute("companies", all);
        return "companies";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company) {

        companyRepository.save(company);
        return "redirect:/companies";
    }


    @GetMapping("/deleteCompany")
    public String deleteCompany(@RequestParam ("id") int id) {
        companyRepository.deleteById(id);
        return  "redirect:/companies";
    }
}
