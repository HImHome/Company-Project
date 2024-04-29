package com.rentzosc.company.project.dtos;

public class BonusDTO {
    private Long bonusId;
    private float amount;
    private CompanyDTO companyDTO;

    private EmployeeDTO employeeDTO;

    public BonusDTO() {
    }

    public BonusDTO(float amount, CompanyDTO companyDTO, EmployeeDTO employeeDTO) {
        this.amount = amount;
        this.companyDTO = companyDTO;
        this.employeeDTO = employeeDTO;
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
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO company) {
        this.companyDTO = company;
    }

    public EmployeeDTO getEmployee() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employee) {
        this.employeeDTO = employee;
    }

    @Override
    public String toString() {
        return "BonusDTO{" + "bonusId=" + bonusId + ", amount=" + amount + ", company=" + companyDTO + ", employee=" + employeeDTO + '}';
    }
}
