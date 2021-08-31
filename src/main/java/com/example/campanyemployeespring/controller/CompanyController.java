package com.example.campanyemployeespring.controller;

import com.example.campanyemployeespring.model.Company;
import com.example.campanyemployeespring.model.Message;
import com.example.campanyemployeespring.repository.CompanyRepository;
import com.example.campanyemployeespring.repository.EmployeeRepository;
import com.example.campanyemployeespring.repository.MessageRepository;
import com.example.campanyemployeespring.service.CompanyService;
import com.example.campanyemployeespring.service.EmployeeService;
import com.example.campanyemployeespring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller

public class CompanyController {

    private CompanyService companyService;

    private EmployeeService employeeService;


    MessageService messageService;

    @GetMapping("/companies")

    public String companies(ModelMap modelMap) {
        List<Company> all = companyService.findAll();
        modelMap.addAttribute("companies", all);
//
        return "companies";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }


    @GetMapping("/deleteCompany")
    public String deleteCompany(@RequestParam("id") int id) {
       employeeService.deleteAllByCompanyId(id);
        companyService.deleteById(id);
        return "redirect:/companies";
    }


}
