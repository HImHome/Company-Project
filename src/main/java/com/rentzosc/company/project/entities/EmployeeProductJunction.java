package com.rentzosc.company.project.entities;

import jakarta.persistence.*;


@Entity
public class EmployeeProductJunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeProductJunctionId;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    @ManyToOne
    @JoinColumn
    private Product product;

    public EmployeeProductJunction() {
    }

    public EmployeeProductJunction(Product product) {
        this.product = product;
    }

    public Long getEmployeeProductJunctionId() {
        return employeeProductJunctionId;
    }

    public void setEmployeeProductJunctionId(Long employeeProductJunctionId) {
        this.employeeProductJunctionId = employeeProductJunctionId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "EmployeeProductJunction{" + "employeeProductJunctionId=" + employeeProductJunctionId + ", employee=" + employee + ", product=" + product + '}';
    }
}
