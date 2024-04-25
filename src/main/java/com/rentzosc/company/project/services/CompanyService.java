package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }


    private CompanyDTO convertCompanyToDto(Company company) {
        return modelMapper.map(company, CompanyDTO.class);
    }


    private Company convertDtoToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);
    }

    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company = convertDtoToCompany(companyDTO);
        System.out.println("Before saving: " + company);
        Company savedCompany = companyRepository.save(company);
        System.out.println("After saving: " + savedCompany);
        return convertCompanyToDto(savedCompany);
    }

    public CompanyDTO getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company " +
                "with ID:" + companyId + " not found."));

        return convertCompanyToDto(company);
    }

    public List<CompanyDTO> getAllCompanies() {
        List<Company> company = companyRepository.findAll();

        return company.stream().map(this::convertCompanyToDto).collect(Collectors.toList());
    }

    public void deleteCompany(Long companyId) {
        if (!companyRepository.existsById(companyId)) {
            throw new RuntimeException("Company " + "with ID:" + companyId + " not found.");
        }

        companyRepository.deleteById(companyId);
    }

    public CompanyDTO updateCompany(Long companyId, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company " +
                "with ID:" + companyId + " not found."));

        modelMapper.map(companyDTO, company);
        Company updatedCompany = companyRepository.save(company);

        return convertCompanyToDto(updatedCompany);
    }
}
