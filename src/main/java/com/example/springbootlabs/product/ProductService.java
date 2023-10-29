package com.example.springbootlabs.product;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository someProductRepository) {
        this.productRepository = someProductRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

}
