package com.rentzosc.company.project.dtos;

public class BonusDTO {
    private Long bonusId;
    private float amount;
    private CompanyDTO company;

    private EmployeeDTO employee;

    public BonusDTO() {
    }

    public BonusDTO(float amount, CompanyDTO company, EmployeeDTO employee) {
        this.amount = amount;
        this.company = company;
        this.employee = employee;
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

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "BonusDTO{" + "bonusId=" + bonusId + ", amount=" + amount + ", company=" + company + ", employee=" + employee + '}';
    }
}
