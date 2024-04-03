package com.rentzosc.company.project.dtos;


public class EmployeeProductJunctionDTO {
    private Long employeeProductJunctionIdDTO;


    private EmployeeDTO employeeDTO;


    private ProductDTO productDTO;

    public EmployeeProductJunctionDTO() {
    }

    public EmployeeProductJunctionDTO(EmployeeDTO employeeDTO, ProductDTO productDTO) {
        this.employeeDTO = employeeDTO;
        this.productDTO = productDTO;
    }

    public Long getEmployeeProductJunctionIdDTO() {
        return employeeProductJunctionIdDTO;
    }

    public void setEmployeeProductJunctionIdDTO(Long employeeProductJunctionIdDTO) {
        this.employeeProductJunctionIdDTO = employeeProductJunctionIdDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "EmployeeProductJunctionDTO{" + "employeeProductJunctionIdDTO=" + employeeProductJunctionIdDTO + ", employeeDTO=" + employeeDTO + ", productDTO=" + productDTO + '}';
    }
}
