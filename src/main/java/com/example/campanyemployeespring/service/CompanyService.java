package com.example.campanyemployeespring.service;

import com.example.campanyemployeespring.model.Company;
import com.example.campanyemployeespring.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {


    private final CompanyRepository companyRepository;

    public void save(Company company) {
        companyRepository.save(company);

    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }


    public Company getById(int id) {
        return companyRepository.getById(id);
    }

    public void deleteById(int id) {

    }

    public Company findCompanyById(int id) {

        return companyRepository.getById(id);
    }

}
