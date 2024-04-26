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

    public Company() {
        this.employees =new ArrayList<>();
    }

    public Company(String companyName, String companyAddress, String companyPhoneNo, List<Employee> employees) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNo = companyPhoneNo;
        this.employees = employees;
    }


    public Long getCompanyId() { return companyId; }

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


    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName='" + companyName + '\'' + ", companyAddress='" + companyAddress + '\'' + ", companyPhoneNo='" + companyPhoneNo + '\'' + ", employees=" + employees + '}';
    }
}
