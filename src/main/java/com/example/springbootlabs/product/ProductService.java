package com.example.springbootlabs.product;

import org.springframework.stereotype.Service;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

}
