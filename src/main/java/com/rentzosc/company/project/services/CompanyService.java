package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private CompanyDTO convertCompanyToDto(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCompanyIdDTO(company.getCompanyId());
        companyDTO.setCompanyNameDTO(company.getCompanyName());
        companyDTO.setCompanyAddressDTO(company.getCompanyAddress());
        companyDTO.setCompanyPhoneNoDTO(company.getGetCompanyPhoneNo());

        return companyDTO;
    }

    private Company convertDtoToCompany(CompanyDTO companyDTO) {
        Company company = new Company();

        company.setCompanyName(companyDTO.getCompanyNameDTO());
        company.setCompanyAddress(companyDTO.getCompanyAddressDTO());
        company.setGetCompanyPhoneNo(companyDTO.getCompanyPhoneNoDTO());

        return  company;
    }

    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company = convertDtoToCompany(companyDTO);
        Company savedCompany = companyRepository.save(company);

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

        company.setCompanyName(companyDTO.getCompanyNameDTO());
        company.setCompanyAddress(companyDTO.getCompanyAddressDTO());
        company.setGetCompanyPhoneNo(companyDTO.getCompanyPhoneNoDTO());

        Company updateCompany = companyRepository.save(company);

        return convertCompanyToDto(updateCompany);
    }
}
