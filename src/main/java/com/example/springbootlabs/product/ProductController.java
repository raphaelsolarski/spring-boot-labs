package com.example.springbootlabs.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @GetMapping
    public List<Product> getProducts() {
        return List.of(new Product(1L, "productName", "product desc", 1.0));
    }

}
