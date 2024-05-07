package com.rentzosc.company.project.dtos;


public class EmployeeProductJunctionDTO {
    private Long employeeProductJunctionId;


    private EmployeeDTO employee;


    private ProductDTO product;

    public EmployeeProductJunctionDTO() {
    }

    public EmployeeProductJunctionDTO(EmployeeDTO employee, ProductDTO product) {
        this.employee = employee;
        this.product = product;
    }

    public Long getEmployeeProductJunctionId() {
        return employeeProductJunctionId;
    }

    public void setEmployeeProductJunctionId(Long employeeProductJunctionId) {
        this.employeeProductJunctionId = employeeProductJunctionId;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "EmployeeProductJunctionDTO{" + "employeeProductJunctionId=" + employeeProductJunctionId + ", employee=" + employee + ", product=" + product + '}';
    }
}
