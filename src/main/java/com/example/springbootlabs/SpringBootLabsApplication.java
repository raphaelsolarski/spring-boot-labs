package com.example.springbootlabs;

import com.example.springbootlabs.product.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootLabsApplication {

    @Bean
    public ProductRepository secondaryRepository() {
        return new ProductRepository() {};
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLabsApplication.class, args);
    }

}
