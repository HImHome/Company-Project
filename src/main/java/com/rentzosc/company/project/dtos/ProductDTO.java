package com.rentzosc.company.project.dtos;

public class ProductDTO {
    private Long productId;
    private String productName;
    private String productDescription;
    private String productBarcode;

    public ProductDTO() {
    }

    public ProductDTO(String productName, String productDescription, String productBarcode) {
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

    @Override
    public String toString() {
        return "ProductDTO{" + "productId=" + productId + ", productName='" + productName + '\'' + ", productDescription='" + productDescription + '\'' + ", productBarcode='" + productBarcode + '\'' + '}';
    }
}
