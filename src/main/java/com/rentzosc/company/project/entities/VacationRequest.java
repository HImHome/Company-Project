package com.rentzosc.company.project.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vacation_request" )
public class VacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long vacationRequestId;

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "status")
    private String status;
    @Column(name = "vacation_duration")
    private Long vacationDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public VacationRequest() {
    }

    public VacationRequest(Employee employee, LocalDate startDate, LocalDate endDate, String status, Long vacationDuration) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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

    public Long getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(Long vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    @Override
    public String toString() {
        return "VacationRequest{" + "vacationRequestId=" + vacationRequestId + ", employee=" + employee + ", startDate=" + startDate + ", endDate=" + endDate + ", status='" + status + '\'' + ", vacationDuration=" + vacationDuration + '}';
    }
}
