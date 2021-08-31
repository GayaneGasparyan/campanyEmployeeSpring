package com.example.campanyemployeespring.security;

import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.repository.EmployeeRepository;
import com.example.campanyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final EmployeeService employeeService;
    private  final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> byEmail = employeeRepository.findByEmail(email);
        if (!byEmail.isPresent()) {
            throw new UsernameNotFoundException("User with " + email + " username does not exists");
        }

        return new CurrentUser(byEmail.get());
    }
}
