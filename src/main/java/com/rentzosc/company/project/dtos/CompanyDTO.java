package com.rentzosc.company.project.dtos;


import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {
    private Long companyId;
    private String companyName;
    private String companyAddress;
    private String companyPhoneNo;
    private List<EmployeeDTO> employees;
    private List<BonusDTO> bonuses;


    public CompanyDTO() {

        this.employees = new ArrayList<>();
        this.bonuses = new ArrayList<>();
    }


    public CompanyDTO(String companyName, String companyAddress, String companyPhoneNo, List<EmployeeDTO> employees, List<BonusDTO> bonuses) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNo = companyPhoneNo;
        this.employees = employees != null ? new ArrayList<>(employees) : new ArrayList<>();
        this.bonuses = bonuses != null ? new ArrayList<>(bonuses) : new ArrayList<>();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhoneNo() {
        return companyPhoneNo;
    }

    public void setCompanyPhoneNo(String companyPhoneNo) {
        this.companyPhoneNo = companyPhoneNo;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees != null ? new ArrayList<>(employees) : new ArrayList<>();
    }

    public List<BonusDTO> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<BonusDTO> bonuses) {
        this.bonuses = bonuses != null ? new ArrayList<>(bonuses) : new ArrayList<>();
    }
}
