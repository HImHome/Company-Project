package com.rentzosc.company.project.configuration;

import com.rentzosc.company.project.dtos.*;
import com.rentzosc.company.project.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        modelMapper.typeMap(VacationRequest.class, VacationRequestDTO.class).addMappings(mapper -> {
            mapper.map(VacationRequest::getVacationRequestId, VacationRequestDTO::setVacationRequestId);
            mapper.map(VacationRequest::getStartDate, VacationRequestDTO::setStartDate);
            mapper.map(VacationRequest::getEndDate, VacationRequestDTO::setEndDate);
            mapper.map(VacationRequest::getStatus, VacationRequestDTO::setStatus);
            mapper.map(VacationRequest::getVacationDuration, VacationRequestDTO::setVacationDuration);
            mapper.map(VacationRequest::getEmployee, VacationRequestDTO::setEmployee);
        });

        modelMapper.typeMap(Product.class, ProductDTO.class).addMappings(mapper -> {
            mapper.map(Product::getProductId, ProductDTO::setProductId);
            mapper.map(Product::getProductName, ProductDTO::setProductName);
            mapper.map(Product::getProductBarcode, ProductDTO::setProductBarcode);
            mapper.map(Product::getProductDescription, ProductDTO::setProductDescription);
        });


        return modelMapper;
    }
}