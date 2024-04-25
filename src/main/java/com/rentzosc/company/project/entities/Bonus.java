package com.rentzosc.company.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bonusId;
    private Long employeeId;
    private Long companyId;


    public Bonus() {
    }

    public Bonus(Long employeeId, Long companyId) {
        this.employeeId = employeeId;
        this.companyId = companyId;
    }

    public Long getBonusId() {
        return bonusId;
    }

    public void setBonusId(Long bonusId) {
        this.bonusId = bonusId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Bonus{" + "bonusId=" + bonusId + ", employeeId=" + employeeId + ", companyId=" + companyId + '}';
    }
}
