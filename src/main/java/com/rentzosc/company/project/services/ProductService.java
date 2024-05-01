package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.ProductDTO;
import com.rentzosc.company.project.entities.Product;
import com.rentzosc.company.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    private ProductDTO convertProductToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private Product convertDtoToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product convertedProduct = convertDtoToProduct(productDTO);
        Product savedProduct = productRepository.save(convertedProduct);

        return convertProductToDto(savedProduct);
    }

    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product " +
                "with ID:" + productId + " not found."));

        return convertProductToDto(product);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertProductToDto)
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new RuntimeException("Product with id: " + productId + " not found.");
        }
    }

    public ProductDTO updateProduct(Long productId, ProductDTO productDetails) {
        return productRepository.findById(productId).map(product -> {
            modelMapper.map(productDetails, product);
            product.setProductId(productId);
            Product updatedProduct = productRepository.save(product);

            return convertProductToDto(updatedProduct);
        }).orElseThrow(() -> new RuntimeException("Product with id: " + productId + " not found."));
    }
}