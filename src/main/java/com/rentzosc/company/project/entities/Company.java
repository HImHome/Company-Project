package com.rentzosc.company.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    Long companyId;
    String companyName;
    String companyAddress;
    Long getCompanyPhoneNo;


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
}
