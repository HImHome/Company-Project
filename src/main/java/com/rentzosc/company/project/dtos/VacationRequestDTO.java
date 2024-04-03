package com.rentzosc.company.project.dtos;

import java.time.LocalDate;

public class VacationRequestDTO {
    private Long vacationRequestIdDTO;
    private Long employeeIdDTO;
    private LocalDate startDateDTO;
    private LocalDate endDateDTO;
    private int vacationDurationDTO;

    public VacationRequestDTO() {
    }

    public VacationRequestDTO(Long employeeIdDTO, LocalDate startDateDTO, LocalDate endDateDTO, int vacationDurationDTO) {
        this.employeeIdDTO = employeeIdDTO;
        this.startDateDTO = startDateDTO;
        this.endDateDTO = endDateDTO;
        this.vacationDurationDTO = vacationDurationDTO;
    }

    public Long getVacationRequestIdDTO() {
        return vacationRequestIdDTO;
    }

    public void setVacationRequestIdDTO(Long vacationRequestIdDTO) {
        this.vacationRequestIdDTO = vacationRequestIdDTO;
    }

    public Long getEmployeeIdDTO() {
        return employeeIdDTO;
    }

    public void setEmployeeIdDTO(Long employeeIdDTO) {
        this.employeeIdDTO = employeeIdDTO;
    }

    public LocalDate getStartDateDTO() {
        return startDateDTO;
    }

    public void setStartDateDTO(LocalDate startDateDTO) {
        this.startDateDTO = startDateDTO;
    }

    public LocalDate getEndDateDTO() {
        return endDateDTO;
    }

    public void setEndDateDTO(LocalDate endDateDTO) {
        this.endDateDTO = endDateDTO;
    }

    public int getVacationDurationDTO() {
        return vacationDurationDTO;
    }

    public void setVacationDurationDTO(int vacationDurationDTO) {
        this.vacationDurationDTO = vacationDurationDTO;
    }

    @Override
    public String toString() {
        return "VacationRequestDTO{" + "vacationRequestIdDTO=" + vacationRequestIdDTO + ", employeeIdDTO=" + employeeIdDTO + ", startDateDTO=" + startDateDTO + ", endDateDTO=" + endDateDTO + ", vacationDurationDTO=" + vacationDurationDTO + '}';
    }
}
