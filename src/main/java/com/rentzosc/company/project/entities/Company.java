package com.rentzosc.company.project.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long companyId;
    @Column(name = "name")
    private String companyName;

    @Column(name = "address")
    private String companyAddress;


    @Column(name = "phone")
    private String companyPhoneNo;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @OneToMany(mappedBy = "company")
    private List<Bonus> bonuses;


    public Company() {

        this.employees = new ArrayList<>();
        this.bonuses = new ArrayList<>();
    }

    public Company(String companyName, String companyAddress, String companyPhoneNo, List<Employee> employees,
                   List<Bonus> bonuses) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNo = companyPhoneNo;
        this.employees = employees;
        this.bonuses = bonuses;
    }


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhoneNo() {
        return companyPhoneNo;
    }

    public void setCompanyPhoneNo(String companyPhoneNo) {
        this.companyPhoneNo = companyPhoneNo;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName='" + companyName + '\'' + ", companyAddress='" + companyAddress + '\'' + ", companyPhoneNo='" + companyPhoneNo + '\'' + ", employees=" + employees + ", bonuses=" + bonuses + '}';
    }
}
