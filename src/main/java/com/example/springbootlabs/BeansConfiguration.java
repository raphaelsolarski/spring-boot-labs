package com.example.springbootlabs;

import com.example.springbootlabs.product.ProductRepository;
import com.example.springbootlabs.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeansConfiguration {

    @Bean
    @Profile("!test")
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

}
