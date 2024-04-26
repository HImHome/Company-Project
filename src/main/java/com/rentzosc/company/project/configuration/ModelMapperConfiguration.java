package com.rentzosc.company.project.configuration;

import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.dtos.EmployeeDTO;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        modelMapper.typeMap(Company.class, CompanyDTO.class).addMappings(mapper -> {
            mapper.map(Company::getCompanyId, CompanyDTO::setCompanyIdDTO);
            mapper.map(Company::getCompanyName, CompanyDTO::setCompanyNameDTO);
            mapper.map(Company::getCompanyAddress, CompanyDTO::setCompanyAddressDTO);
            mapper.map(Company::getCompanyPhoneNo, CompanyDTO::setCompanyPhoneNoDTO);
        });

        modelMapper.typeMap(Employee.class, EmployeeDTO.class).addMappings(mapper -> {
            mapper.map(Employee::getEmployeeId, EmployeeDTO::setEmployeeIdDTO);
            mapper.map(Employee::getFirstName, EmployeeDTO::setFirstNameDTO);
            mapper.map(Employee::getLastName, EmployeeDTO::setLastNameDTO);
            mapper.map(Employee::getEmail, EmployeeDTO::setEmailDTO);
            mapper.map(Employee::getSalary, EmployeeDTO::setSalaryDTO);
            mapper.map(Employee::getHireDate, EmployeeDTO::setHireDateDTO);
            mapper.map(Employee::getVacationDays, EmployeeDTO::setVacationDaysDTO);
            mapper.map(Employee::getEmployeeAge, EmployeeDTO::setEmployeeAgeDTO);
            mapper.map(Employee::getCompany, EmployeeDTO::setCompanyDTO);
        });


        return modelMapper;
    }
}