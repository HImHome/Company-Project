package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.ProductDTO;
import com.rentzosc.company.project.entities.Product;
import com.rentzosc.company.project.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductDTO convertProductToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductIdDTO(product.getProductId());
        productDTO.setProductNameDTO(product.getProductName());
        productDTO.setProductBarcodeDTO(product.getProductBarcode());
        productDTO.setProductDescriptionDTO(product.getProductDescription());

        return productDTO;
    }

    private Product convertDtoToProduct(ProductDTO productDTO) {
        Product product = new Product();

        product.setProductName(productDTO.getProductNameDTO());
        product.setProductBarcode(productDTO.getProductBarcodeDTO());
        product.setProductDescription(productDTO.getProductDescriptionDTO());


        return product;
    }

    public ProductDTO addCompany(ProductDTO productDTO) {
        Product product = convertDtoToProduct(productDTO);
        Product addProduct = productRepository.save(product);

        return convertProductToDto(addProduct);
    }

    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product " +
                "with ID:" + productId + " not found."));

        return convertProductToDto(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::convertProductToDto).collect(Collectors.toList());
    }

    private void deleteProduct(Long productId) {
        if(!productRepository.existsById(productId)){
            throw new RuntimeException("Product " +
                    "with ID:" + productId + " not found.");
        }

        productRepository.deleteById(productId);
    }

    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product product = new Product();

        product.setProductName(productDTO.getProductNameDTO());
        product.setProductBarcode(productDTO.getProductBarcodeDTO());
        product.setProductDescription(productDTO.getProductDescriptionDTO());

        return convertProductToDto(product);
    }

}
