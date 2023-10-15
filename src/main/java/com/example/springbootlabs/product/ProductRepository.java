package com.example.springbootlabs.product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> getProducts() {
        return List.of(new Product(1L, "productName", "product desc", 1.0));
    }

}
