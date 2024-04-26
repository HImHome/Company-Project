package com.rentzosc.company.project.dtos;


import java.time.LocalDate;

public class EmployeeDTO {
    private Long employeeIdDTO;
    private Long salaryDTO;
    private String firstNameDTO;
    private String lastNameDTO;
    private String emailDTO;
    private LocalDate hireDateDTO;
    private String vacationDaysDTO;
    private String employeeAgeDTO;
    private CompanyDTO companyDTO;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long salaryDTO, String firstNameDTO, String lastNameDTO, String emailDTO,
                       LocalDate hireDateDTO, String vacationDaysDTO, String employeeAgeDTO, CompanyDTO companyDTO) {
        this.salaryDTO = salaryDTO;
        this.firstNameDTO = firstNameDTO;
        this.lastNameDTO = lastNameDTO;
        this.emailDTO = emailDTO;
        this.hireDateDTO = hireDateDTO;
        this.vacationDaysDTO = vacationDaysDTO;
        this.employeeAgeDTO = employeeAgeDTO;
        this.companyDTO = companyDTO;
    }

    public Long getEmployeeIdDTO() {
        return employeeIdDTO;
    }

    public void setEmployeeIdDTO(Long employeeIdDTO) {
        this.employeeIdDTO = employeeIdDTO;
    }

    public Long getSalaryDTO() {
        return salaryDTO;
    }

    public void setSalaryDTO(Long salaryDTO) {
        this.salaryDTO = salaryDTO;
    }

    public String getFirstNameDTO() {
        return firstNameDTO;
    }

    public void setFirstNameDTO(String firstNameDTO) {
        this.firstNameDTO = firstNameDTO;
    }

    public String getLastNameDTO() {
        return lastNameDTO;
    }

    public void setLastNameDTO(String lastNameDTO) {
        this.lastNameDTO = lastNameDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public LocalDate getHireDateDTO() {
        return hireDateDTO;
    }

    public void setHireDateDTO(LocalDate hireDateDTO) {
        this.hireDateDTO = hireDateDTO;
    }

    public String getVacationDaysDTO() {
        return vacationDaysDTO;
    }

    public void setVacationDaysDTO(String vacationDaysDTO) {
        this.vacationDaysDTO = vacationDaysDTO;
    }

    public String getEmployeeAgeDTO() {
        return employeeAgeDTO;
    }

    public void setEmployeeAgeDTO(String employeeAgeDTO) {
        this.employeeAgeDTO = employeeAgeDTO;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeIdDTO=" + employeeIdDTO + ", salaryDTO=" + salaryDTO + ", firstNameDTO='" + firstNameDTO + '\'' + ", lastNameDTO='" + lastNameDTO + '\'' + ", emailDTO='" + emailDTO + '\'' + ", hireDateDTO=" + hireDateDTO + ", vacationDaysDTO='" + vacationDaysDTO + '\'' + ", employeeAgeDTO='" + employeeAgeDTO + '\'' + ", companyDTO=" + companyDTO + '}';
    }
}
