package com.rentzosc.company.project.dtos;

public class CompanyDTO {
    private Long companyIdDTO;
    private String companyNameDTO;
    private String companyAddressDTO;
    private Long companyPhoneNoDTO;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyNameDTO, String companyAddressDTO, Long companyPhoneNoDTO) {
        this.companyNameDTO = companyNameDTO;
        this.companyAddressDTO = companyAddressDTO;
        this.companyPhoneNoDTO = companyPhoneNoDTO;
    }

    public Long getCompanyIdDTO() {
        return companyIdDTO;
    }

    public void setCompanyIdDTO(Long companyIdDTO) {
        this.companyIdDTO = companyIdDTO;
    }

    public String getCompanyNameDTO() {
        return companyNameDTO;
    }

    public void setCompanyNameDTO(String companyNameDTO) {
        this.companyNameDTO = companyNameDTO;
    }

    public String getCompanyAddressDTO() {
        return companyAddressDTO;
    }

    public void setCompanyAddressDTO(String companyAddressDTO) {
        this.companyAddressDTO = companyAddressDTO;
    }

    public Long getCompanyPhoneNoDTO() {
        return companyPhoneNoDTO;
    }

    public void setCompanyPhoneNoDTO(Long companyPhoneNoDTO) {
        this.companyPhoneNoDTO = companyPhoneNoDTO;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" + "companyIdDTO=" + companyIdDTO + ", companyNameDTO='" + companyNameDTO + '\'' + ", " +
                "companyAddressDTO='" + companyAddressDTO + '\'' + ", companyPhoneNoDTO=" + companyPhoneNoDTO + '}';
    }
}
