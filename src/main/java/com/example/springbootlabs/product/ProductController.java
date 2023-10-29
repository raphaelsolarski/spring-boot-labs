package com.example.springbootlabs.product;

import com.example.springbootlabs.comment.Comment;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Comment> getProducts(){
        return productRepository.findAllProducts(PageRequest.of(0,5));
    }

}
