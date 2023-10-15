package com.example.springbootlabs.product;

import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProductService {

    public List<Product> getProducts() {
        return List.of(new Product(1L, "productName", "product desc", 1.0));
    }

}
