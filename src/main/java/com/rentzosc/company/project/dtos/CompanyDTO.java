package com.rentzosc.company.project.dtos;


import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {
    private Long companyIdDTO;
    private String companyNameDTO;
    private String companyAddressDTO;
    private String companyPhoneNoDTO;
    private List<EmployeeDTO> employees;
    private BonusDTO bonus;


    public CompanyDTO() {
        this.employees = new ArrayList<>();
    }

    public CompanyDTO(String companyNameDTO, String companyAddressDTO, String companyPhoneNoDTO,
                      List<EmployeeDTO> employees,BonusDTO bonus) {
        this.companyNameDTO = companyNameDTO;
        this.companyAddressDTO = companyAddressDTO;
        this.companyPhoneNoDTO = companyPhoneNoDTO;
        this.employees = employees;
        this.bonus = bonus;
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

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public BonusDTO getBonus() {
        return bonus;
    }

    public void setBonus(BonusDTO bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" + "companyIdDTO=" + companyIdDTO + ", companyNameDTO='" + companyNameDTO + '\'' + ", companyAddressDTO='" + companyAddressDTO + '\'' + ", companyPhoneNoDTO='" + companyPhoneNoDTO + '\'' + ", employees=" + employees + ", bonus=" + bonus + '}';
    }
}
