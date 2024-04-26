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

    public Company convertDtoToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);

    }

   @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
       return ResponseEntity.ok(companyService.addCompany(company));
    }


    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
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
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyId, @RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompany(companyId, company));
    }


    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
}
