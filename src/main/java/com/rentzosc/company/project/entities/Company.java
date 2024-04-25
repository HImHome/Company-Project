package com.rentzosc.company.project.entities;

import jakarta.persistence.*;


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

    public Company() {
    }

    public Company(String companyName, String companyAddress, String companyPhoneNo) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNo = companyPhoneNo;
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

    public String setCompanyPhoneNo() {
        return companyPhoneNo;
    }

    public void getCompanyPhoneNo(String companyPhoneNo) {
        this.companyPhoneNo = companyPhoneNo;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName='" + companyName + '\'' + ", companyAddress='" + companyAddress + '\'' + ", CompanyPhoneNo=" + companyPhoneNo + '}';
    }
}
