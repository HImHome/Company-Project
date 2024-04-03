package com.rentzosc.company.project.dtos;

public class BonusDTO {
    private Long bonusIdDTO;
    private Long employeeIdDTO;
    private Long companyIdDTO;

    public BonusDTO() {
    }


    public BonusDTO(Long employeeIdDTO, Long companyIdDTO) {
        this.employeeIdDTO = employeeIdDTO;
        this.companyIdDTO = companyIdDTO;
    }

    public Long getBonusIdDTO() {
        return bonusIdDTO;
    }

    public void setBonusIdDTO(Long bonusIdDTO) {
        this.bonusIdDTO = bonusIdDTO;
    }

    public Long getEmployeeIdDTO() {
        return employeeIdDTO;
    }

    public void setEmployeeIdDTO(Long employeeIdDTO) {
        this.employeeIdDTO = employeeIdDTO;
    }

    public Long getCompanyIdDTO() {
        return companyIdDTO;
    }

    public void setCompanyIdDTO(Long companyIdDTO) {
        this.companyIdDTO = companyIdDTO;
    }

    @Override
    public String toString() {
        return "BonusDTO{" + "bonusIdDTO=" + bonusIdDTO + ", employeeIdDTO=" + employeeIdDTO + ", companyIdDTO=" + companyIdDTO + '}';
    }
}
