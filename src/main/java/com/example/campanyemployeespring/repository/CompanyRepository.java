package com.example.campanyemployeespring.repository;

import com.example.campanyemployeespring.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
