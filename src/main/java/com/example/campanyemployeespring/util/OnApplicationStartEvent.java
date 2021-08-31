package com.example.campanyemployeespring.util;

import com.example.campanyemployeespring.model.Company;
import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.model.EmployeeType;
import com.example.campanyemployeespring.repository.CompanyRepository;
import com.example.campanyemployeespring.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnApplicationStartEvent implements ApplicationListener<ApplicationReadyEvent> {


    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    private final CompanyRepository companyRepository;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        if (!employeeRepository.findByEmail("admin@mail.com").isPresent()) {

          Company comp =  companyRepository.save(Company.builder()
                     .name("Default company")
                    .address("address")
                    .build());
            employeeRepository.save(Employee.builder()
                    .email("admin@mail.com")
                    .password(passwordEncoder.encode("admin"))
                    .surname("admin")
                    .name("admin")
                    .employeeType(EmployeeType.ADMIN)
                    .company(comp)
                    .build());
        }
    }

}