package com.example.springbootlabs;

import com.example.springbootlabs.product.ProductRepository;
import com.example.springbootlabs.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootLabsApplication {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLabsApplication.class, args);
    }

}
