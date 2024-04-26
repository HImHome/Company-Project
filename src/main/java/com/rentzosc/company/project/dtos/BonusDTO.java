package com.rentzosc.company.project.dtos;

import java.util.ArrayList;
import java.util.List;

public class BonusDTO {
    private Long bonusId;
    private float amount;
    private List<EmployeeDTO> employees;
    private List<CompanyDTO> companies;


    public BonusDTO() {
        this.employees = new ArrayList<>();
        this.companies = new ArrayList<>();
    }

    public BonusDTO(Long bonusId, float amount, List<EmployeeDTO> employees, List<CompanyDTO> companies) {
        this.bonusId = bonusId;
        this.amount = amount;
        this.employees = employees;
        this.companies = companies;
    }

    public Long getBonusId() {
        return bonusId;
    }

    public void setBonusId(Long bonusId) {
        this.bonusId = bonusId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public List<CompanyDTO> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyDTO> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "BonusDTO{" + "bonusId=" + bonusId + ", amount=" + amount + ", employees=" + employees + ", companies=" + companies + '}';
    }
}
