package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Company convertDtoToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);

    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);

    }

    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company " +
                "with ID:" + companyId + " not found."));

    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void deleteCompany(Long companyId) {
        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
        } else {
            throw new RuntimeException("Employee with id: " + companyId + " not found.");
        }
    }

    public Company updateCompany(Long companyId, Company companyDetails) {
        return companyRepository.findById(companyId).map(company -> {
            modelMapper.map(companyDetails, company);
            return companyRepository.save(company);
        }).orElseThrow(() -> new RuntimeException("Employee with id: " + companyId + " not found."));
    }
}
