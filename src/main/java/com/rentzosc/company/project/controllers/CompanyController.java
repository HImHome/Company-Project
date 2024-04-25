package com.rentzosc.company.project.controllers;

import com.rentzosc.company.project.dtos.CompanyDTO;
import com.rentzosc.company.project.entities.Company;
import com.rentzosc.company.project.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    private CompanyDTO convertCompanyToDto(Company company) {
        return modelMapper.map(company, CompanyDTO.class);
    }

    private final Company convertDtoToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO savedCompanyDto = companyService.addCompany(companyDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompanyDto);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long companyId) {
        CompanyDTO companyDTO = companyService.getCompanyById(companyId);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(companyDTO);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        try {
            companyService.deleteCompany(companyId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long companyId, @RequestBody CompanyDTO companyDTO) {
        CompanyDTO updatedCompanyDto = companyService.updateCompany(companyId, companyDTO);

        return ResponseEntity.ok(updatedCompanyDto);
    }


    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllEmployees() {
        List<CompanyDTO> companyDTOs = companyService.getAllCompanies();
        return ResponseEntity.ok(companyDTOs);
    }
}
