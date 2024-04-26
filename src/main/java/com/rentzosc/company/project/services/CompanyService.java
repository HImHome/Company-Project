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


    public Company convertDtoToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);

    }

    public CompanyDTO addCompany(Company company) {
        Company savedCompany =  companyRepository.save(company);

        return convertCompanyToDto(savedCompany);
    }

    public CompanyDTO getCompanyById(Long companyId) {
        Company company =  companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company " +
                "with ID:" + companyId + " not found."));

        return convertCompanyToDto(company);
    }

    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream().
                map(this::convertCompanyToDto).collect(Collectors.toList());
    }

    public void deleteCompany(Long companyId) {
        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
        } else {
            throw new RuntimeException("Employee with id: " + companyId + " not found.");
        }
    }

    public CompanyDTO updateCompany(Long companyId, Company companyDetails) {
        return companyRepository.findById(companyId).map(company -> {
            modelMapper.map(companyDetails, company);
            company.setCompanyId(companyId);
            Company updatedCompany = companyRepository.save(company);

            return modelMapper.map(updatedCompany, CompanyDTO.class);
        }).orElseThrow(() -> new RuntimeException("Company with id: " + companyId + " not found."));
    }
}
