package com.rentzosc.company.project.dtos;


import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {
    private Long companyIdDTO;
    private String companyNameDTO;
    private String companyAddressDTO;
    private String companyPhoneNoDTO;

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }


    public CompanyDTO() {
        this.employees = new ArrayList<>();
    }

    public CompanyDTO(String companyNameDTO, String companyAddressDTO, String companyPhoneNoDTO,
                      List<EmployeeDTO> employees) {
        this.companyNameDTO = companyNameDTO;
        this.companyAddressDTO = companyAddressDTO;
        this.companyPhoneNoDTO = companyPhoneNoDTO;
        this.employees = employees;
    }

    public Long getCompanyIdDTO() {
        return companyIdDTO;
    }

    public void setCompanyIdDTO(Long companyIdDTO) {
        this.companyIdDTO = companyIdDTO;
    }

    public String getCompanyNameDTO() {
        return companyNameDTO;
    }

    public void setCompanyNameDTO(String companyNameDTO) {
        this.companyNameDTO = companyNameDTO;
    }

    public String getCompanyAddressDTO() {
        return companyAddressDTO;
    }

    public void setCompanyAddressDTO(String companyAddressDTO) {
        this.companyAddressDTO = companyAddressDTO;
    }

    public String getCompanyPhoneNoDTO() {
        return companyPhoneNoDTO;
    }
    public void setCompanyPhoneNoDTO(String companyPhoneNoDTO) {
        this.companyPhoneNoDTO = companyPhoneNoDTO;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    private List<EmployeeDTO> employees;

    @Override
    public String toString() {
        return "CompanyDTO{" + "companyIdDTO=" + companyIdDTO + ", companyNameDTO='" + companyNameDTO + '\'' + ", companyAddressDTO='" + companyAddressDTO + '\'' + ", companyPhoneNoDTO='" + companyPhoneNoDTO + '\'' + ", employees=" + employees + '}';
    }
}
