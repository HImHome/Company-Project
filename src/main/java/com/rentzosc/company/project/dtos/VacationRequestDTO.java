package com.rentzosc.company.project.dtos;

import java.time.LocalDate;

public class VacationRequestDTO {
    private Long vacationRequestId;
    private LocalDate startDate;
    private LocalDate endDate;

    private String status;
    private int vacationDuration;

    private EmployeeDTO employee;

    public VacationRequestDTO() {
    }

    public VacationRequestDTO(EmployeeDTO employee, LocalDate startDate, LocalDate endDate, String status, int vacationDuration) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.vacationDuration = vacationDuration;
        this.employee = employee;
    }

    public Long getVacationRequestId() {
        return vacationRequestId;
    }

    public void setVacationRequestId(Long vacationRequestId) {
        this.vacationRequestId = vacationRequestId;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(int vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    @Override
    public String toString() {
        return "VacationRequestDTO{" + "vacationRequestId=" + vacationRequestId + ", employee=" + employee + ", startDate=" + startDate + ", endDate=" + endDate + ", status='" + status + '\'' + ", vacationDuration=" + vacationDuration + '}';
    }
}
