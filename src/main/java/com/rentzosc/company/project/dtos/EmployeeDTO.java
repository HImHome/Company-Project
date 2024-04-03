package com.rentzosc.company.project.dtos;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long employeeIdDTO;
    private Long salaryDTO;
    private Long companyIdDTO;
    private String firstNameDTO;
    private String lastNameDTO;
    private String emailDTO;
    private LocalDate hireDateDTO;
    private int vacationDaysDTO;
    private int employeeAgeDTO;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long salaryDTO, Long companyIdDTO, String firstNameDTO, String lastNameDTO, String emailDTO, LocalDate hireDateDTO, int vacationDaysDTO, int employeeAgeDTO) {
        this.salaryDTO = salaryDTO;
        this.companyIdDTO = companyIdDTO;
        this.firstNameDTO = firstNameDTO;
        this.lastNameDTO = lastNameDTO;
        this.emailDTO = emailDTO;
        this.hireDateDTO = hireDateDTO;
        this.vacationDaysDTO = vacationDaysDTO;
        this.employeeAgeDTO = employeeAgeDTO;
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

    public Long getCompanyIdDTO() {
        return companyIdDTO;
    }

    public void setCompanyIdDTO(Long companyIdDTO) {
        this.companyIdDTO = companyIdDTO;
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

    public int getVacationDaysDTO() {
        return vacationDaysDTO;
    }

    public void setVacationDaysDTO(int vacationDaysDTO) {
        this.vacationDaysDTO = vacationDaysDTO;
    }

    public int getEmployeeAgeDTO() {
        return employeeAgeDTO;
    }

    public void setEmployeeAgeDTO(int employeeAgeDTO) {
        this.employeeAgeDTO = employeeAgeDTO;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeIdDTO=" + employeeIdDTO + ", salaryDTO=" + salaryDTO + ", companyIdDTO=" + companyIdDTO + ", firstNameDTO='" + firstNameDTO + '\'' + ", lastNameDTO='" + lastNameDTO + '\'' + ", emailDTO='" + emailDTO + '\'' + ", hireDateDTO=" + hireDateDTO + ", vacationDaysDTO=" + vacationDaysDTO + ", employeeAgeDTO=" + employeeAgeDTO + '}';
    }
}
