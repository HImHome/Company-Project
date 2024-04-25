package com.rentzosc.company.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    private String companyAddress;
    private Long getCompanyPhoneNo;


    public Company() {
    }

    public Company(String companyName, String companyAddress, Long getCompanyPhoneNo) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.getCompanyPhoneNo = getCompanyPhoneNo;
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

    public Long getGetCompanyPhoneNo() {
        return getCompanyPhoneNo;
    }

    public void setGetCompanyPhoneNo(Long getCompanyPhoneNo) {
        this.getCompanyPhoneNo = getCompanyPhoneNo;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName='" + companyName + '\'' + ", companyAddress='" + companyAddress + '\'' + ", getCompanyPhoneNo=" + getCompanyPhoneNo + '}';
    }
}
