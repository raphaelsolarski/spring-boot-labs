package com.example.springbootlabs.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final List<ProductRepository> productRepository;

    public ProductService(List<ProductRepository> productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.get(0).getProducts();
    }

}
