package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.EmployeeDTO;
import com.rentzosc.company.project.entities.Employee;
import com.rentzosc.company.project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeDTO convertEmployeeToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeIdDTO(employee.getEmployeeId());
        employeeDTO.setCompanyIdDTO(employee.getCompanyId());
        employeeDTO.setFirstNameDTO(employee.getFirstName());
        employeeDTO.setLastNameDTO(employee.getLastName());
        employeeDTO.setEmailDTO(employee.getEmail());
        employeeDTO.setSalaryDTO(employee.getSalary());
        employeeDTO.setHireDateDTO(employee.getHireDate());
        employeeDTO.setVacationDaysDTO(employee.getVacationDays());
        employeeDTO.setEmployeeAgeDTO(employee.getEmployeeAge());

        return employeeDTO;
    }

    private Employee convertDtoToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setCompanyId(employeeDTO.getCompanyIdDTO());
        employee.setFirstName(employeeDTO.getFirstNameDTO());
        employee.setLastName(employeeDTO.getLastNameDTO());
        employee.setEmail(employeeDTO.getEmailDTO());
        employee.setSalary(employeeDTO.getSalaryDTO());
        employee.setHireDate(employeeDTO.getHireDateDTO());
        employee.setVacationDays(employeeDTO.getVacationDaysDTO());
        employee.setEmployeeAge(employeeDTO.getEmployeeAgeDTO());

        return employee;
    }


    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertDtoToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return convertEmployeeToDto(savedEmployee);
    }

    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee " +
                "with ID:" + employeeId + " not found."));

        return convertEmployeeToDto(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(this::convertEmployeeToDto).collect(Collectors.toList());
    }

    public void deleteEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found.");
        }
        employeeRepository.deleteById(employeeId);
    }


    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee " + "with ID:" + employeeId + " not found."));

        employee.setFirstName(employeeDTO.getFirstNameDTO());
        employee.setLastName(employeeDTO.getLastNameDTO());
        employee.setEmail(employeeDTO.getEmailDTO());
        employee.setSalary(employeeDTO.getSalaryDTO());
        employee.setHireDate(employeeDTO.getHireDateDTO());
        employee.setVacationDays(employeeDTO.getVacationDaysDTO());
        employee.setEmployeeAge(employee.getEmployeeAge());

        Employee updateEmployee = employeeRepository.save(employee);
        return convertEmployeeToDto(updateEmployee);
    }
}
