package com.rentzosc.company.project.services;

import com.rentzosc.company.project.entities.Employee;
import com.rentzosc.company.project.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getAllEmployees(Employee employee) {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)){
            throw new RuntimeException("Employee with id: " + employeeId + " not found.");
        }
        employeeRepository.deleteById(employeeId);
    }

    /*public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    if (updatedEmployee.getFirstName() != null) {
                        employee.setFirstName(updatedEmployee.getFirstName());
                    }
                    if (updatedEmployee.getLastName() != null) {
                        employee.setLastName(updatedEmployee.getLastName());
                    }
                    if (updatedEmployee.getEmail() != null) {
                        employee.setEmail(updatedEmployee.getEmail());
                    }
                    if (updatedEmployee.getSalary() != null) {
                        employee.setSalary(updatedEmployee.getSalary());
                    }
                    if (updatedEmployee.getCompanyId() != null) {
                        employee.setCompanyId(updatedEmployee.getCompanyId());
                    }
                        employee.setEmployeeAge(updatedEmployee.getEmployeeAge());
                    }


                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee with id: " + employeeId + " not found."));
    }

    public Employee replaceEmployee(Long employeeId, Employee updatedEmployee) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found.");
        }
        updatedEmployee.setEmployeeId(employeeId);
        return employeeRepository.save(updatedEmployee);
    }*/


}
