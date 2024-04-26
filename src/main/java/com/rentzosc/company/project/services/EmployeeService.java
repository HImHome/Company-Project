package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.dtos.EmployeeDTO;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.entities.Employee;
import com.rentzosc.company.project.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    private EmployeeDTO convertEmployeeToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    private Employee convertDtoToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    @Transactional
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


    public EmployeeDTO updateEmployee(Long employeeId, Employee employeeDetails) {
        return employeeRepository.findById(employeeId).map(employee -> {
            modelMapper.map(employeeDetails, employee);
            employee.setEmployeeId(employeeId);
            Employee updatedCompany = employeeRepository.save(employee);

            return modelMapper.map(updatedCompany, EmployeeDTO.class);
        }).orElseThrow(() -> new RuntimeException("Company with id: " + employeeId + " not found."));
    }
}
