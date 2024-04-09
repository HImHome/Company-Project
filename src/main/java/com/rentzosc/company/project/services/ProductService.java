package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.ProductDTO;
import com.rentzosc.company.project.entities.Product;
import com.rentzosc.company.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

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
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product with " +
                "ID:" + productId + " not found."));

        modelMapper.map(productDTO, product);
        Product updatedProduct = productRepository.save(product);

        return convertProductToDto(updatedProduct);
    }

}
