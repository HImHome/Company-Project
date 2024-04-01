package com.rentzosc.company.project.entities;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class VacationRequest {
    @Id
    Long vacationRequestId;
    Long employeeId;
    LocalDate startDate;
    LocalDate endDate;
    int vacationDuration;

    public VacationRequest() {
    }

    public VacationRequest(Long employeeId, LocalDate startDate, LocalDate endDate, int vacationDuration) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationDuration = vacationDuration;
    }


    public Long getVacationRequestId() {
        return vacationRequestId;
    }

    public void setVacationRequestId(Long vacationRequestId) {
        this.vacationRequestId = vacationRequestId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public int getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(int vacationDuration) {
        this.vacationDuration = vacationDuration;
    }
}
