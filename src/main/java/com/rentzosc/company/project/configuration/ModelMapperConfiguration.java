package com.rentzosc.company.project.configuration;

import com.rentzosc.company.project.dtos.BonusDTO;
import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.dtos.EmployeeDTO;
import com.rentzosc.company.project.entities.Bonus;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        modelMapper.typeMap(Company.class, CompanyDTO.class).addMappings(mapper -> {
            mapper.map(Company::getCompanyId, CompanyDTO::setCompanyId);
            mapper.map(Company::getCompanyName, CompanyDTO::setCompanyName);
            mapper.map(Company::getCompanyAddress, CompanyDTO::setCompanyAddress);
            mapper.map(Company::getCompanyPhoneNo, CompanyDTO::setCompanyPhoneNo);
            mapper.map(src -> src.getEmployees() != null ? src.getEmployees().stream()
                    .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                    .collect(Collectors.toList()) : new ArrayList<>(), CompanyDTO::setEmployees);
            mapper.map(src -> src.getBonuses() != null ? src.getBonuses().stream()
                    .map(bonus -> modelMapper.map(bonus, BonusDTO.class))
                    .collect(Collectors.toList()) : new ArrayList<>(), CompanyDTO::setBonuses);
        });


        modelMapper.typeMap(Employee.class, EmployeeDTO.class).addMappings(mapper -> {
            mapper.map(Employee::getEmployeeId, EmployeeDTO::setEmployeeId);
            mapper.map(Employee::getFirstName, EmployeeDTO::setFirstName);
            mapper.map(Employee::getLastName, EmployeeDTO::setLastName);
            mapper.map(Employee::getEmail, EmployeeDTO::setEmail);
            mapper.map(Employee::getSalary, EmployeeDTO::setSalary);
            mapper.map(Employee::getHireDate, EmployeeDTO::setHireDate);
            mapper.map(Employee::getVacationDays, EmployeeDTO::setVacationDays);
            mapper.map(Employee::getEmployeeAge, EmployeeDTO::setEmployeeAge);
            mapper.map(Employee::getCompany, EmployeeDTO::setCompany);
        });

        modelMapper.typeMap(Bonus.class, BonusDTO.class).addMappings(mapper -> {
            mapper.map(Bonus::getBonusId, BonusDTO::setBonusId);
            mapper.map(Bonus::getAmount, BonusDTO::setAmount);
            mapper.map(Bonus::getCompany, BonusDTO::setCompany);
            mapper.map(Bonus::getEmployee, BonusDTO::setEmployee);
        });


        return modelMapper;
    }
}