package com.rentzosc.company.project.dtos;

public class ProductDTO {


    private Long productIdDTO;
    private String productNameDTO;
    private String productDescriptionDTO;
    private String productBarcodeDTO;

    public ProductDTO() {
    }

    public ProductDTO(String productNameDTO, String productDescriptionDTO, String productBarcodeDTO) {
        this.productNameDTO = productNameDTO;
        this.productDescriptionDTO = productDescriptionDTO;
        this.productBarcodeDTO = productBarcodeDTO;
    }

    public Long getProductIdDTO() {
        return productIdDTO;
    }

    public void setProductIdDTO(Long productIdDTO) {
        this.productIdDTO = productIdDTO;
    }

    public String getProductNameDTO() {
        return productNameDTO;
    }

    public void setProductNameDTO(String productNameDTO) {
        this.productNameDTO = productNameDTO;
    }

    public String getProductDescriptionDTO() {
        return productDescriptionDTO;
    }

    public void setProductDescriptionDTO(String productDescriptionDTO) {
        this.productDescriptionDTO = productDescriptionDTO;
    }

    public String getProductBarcodeDTO() {
        return productBarcodeDTO;
    }

    public void setProductBarcodeDTO(String productBarcodeDTO) {
        this.productBarcodeDTO = productBarcodeDTO;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productIdDTO=" + productIdDTO + ", productNameDTO='" + productNameDTO + '\'' + ", productDescriptionDTO='" + productDescriptionDTO + '\'' + ", productBarcodeDTO='" + productBarcodeDTO + '\'' + '}';
    }
}
