package com.rentzosc.company.project.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bonusId;
    private float amount;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bonus")
    private List<Employee> employees;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bonus")
    private List<Company> companies;

    public Bonus() {
        this.employees = new ArrayList<>();
        this.companies = new ArrayList<>();
    }

    public Bonus(float amount, List<Employee> employees, List<Company> companies) {
        this.amount = amount;
        this.employees = employees;
        this.companies = companies;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Bonus{" + "bonusId=" + bonusId + ", amount=" + amount + ", employees=" + employees + ", companies=" + companies + '}';
    }
}
