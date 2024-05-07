package com.rentzosc.company.project.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;
    @Column(name = "name")
    private String productName;
    @Column(name = "barcode")
    private String productBarcode;
    @Column(name = "description")
    private String productDescription;

    @OneToMany(mappedBy = "product")
    private Set<EmployeeProductJunction> employeeProductJunctionSet = new HashSet<>();


    public Product() {
    }

    public Product(String productName, String productBarcode, String productDescription, Set<EmployeeProductJunction> employeeProductJunctionSet) {
        this.productName = productName;
        this.productBarcode = productBarcode;
        this.productDescription = productDescription;
        this.employeeProductJunctionSet = employeeProductJunctionSet;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Set<EmployeeProductJunction> getEmployeeProductJunctionSet() {
        return employeeProductJunctionSet;
    }

    public void setEmployeeProductJunctionSet(Set<EmployeeProductJunction> employeeProductJunctionSet) {
        this.employeeProductJunctionSet = employeeProductJunctionSet;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", productBarcode='" + productBarcode + '\'' + ", productDescription='" + productDescription + '\'' + ", employeeProductJunctionSet=" + employeeProductJunctionSet + '}';
    }
}
