package com.example.springbootlabs.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository someProductRepository) {
        this.productRepository = someProductRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

}
