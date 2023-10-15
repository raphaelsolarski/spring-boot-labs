package com.example.springbootlabs.product;

import java.util.List;

public class ProductService {

    public List<Product> getProducts() {
        return List.of(new Product(1L, "productName", "product desc", 1.0));
    }

}
