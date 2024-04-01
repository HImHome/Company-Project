package com.rentzosc.company.project.entities;

import jakarta.persistence.Id;

public class Product {
    @Id
    Long productId;
    String productName;
    String productDescription;
    String productBarcode;


    public Product() {
    }

    public Product(String productName, String productDescription, String productBarcode) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productBarcode = productBarcode;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }
}
