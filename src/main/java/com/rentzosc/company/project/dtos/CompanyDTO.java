package com.rentzosc.company.project.dtos;


public class CompanyDTO {
    private Long companyId;
    private String companyName;
    private String companyAddress;
    private String companyPhoneNo;


    public CompanyDTO() {
    }

    public CompanyDTO(String companyName, String companyAddress, String companyPhoneNo) {
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

    public String getCompanyPhoneNo() {
        return companyPhoneNo;
    }

    public void setCompanyPhoneNo(String companyPhoneNo) {
        this.companyPhoneNo = companyPhoneNo;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" + "companyId=" + companyId + ", companyName='" + companyName + '\'' + ", companyAddress='" + companyAddress + '\'' + ", companyPhoneNo='" + companyPhoneNo + '\'' + '}';
    }
}
