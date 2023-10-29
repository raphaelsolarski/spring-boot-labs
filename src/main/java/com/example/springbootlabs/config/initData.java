package com.example.springbootlabs.config;

import com.example.springbootlabs.comment.Comment;
import com.example.springbootlabs.comment.CommentRepository;
import com.example.springbootlabs.comment.CommentType;
import com.example.springbootlabs.order.Order;
import com.example.springbootlabs.order.OrderRepository;
import com.example.springbootlabs.product.Product;
import com.example.springbootlabs.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;

@Component
public class initData implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;
    private final OrderRepository orderRepository;
    public initData(ProductRepository productRepository, CommentRepository commentRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
        this.orderRepository = orderRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            Product product = new Product("Product-" + i, null, new HashSet<>());
            product = productRepository.save(product);

            Comment comment = new Comment("This is comment for Product-" + i, CommentType.ACTIVE);
            comment.setProduct(product);
            commentRepository.save(comment);

            product.getComments().add(comment);
            productRepository.save(product);
        }

        Order order1 = new Order();
        order1.setCreatedTime(LocalDateTime.now());
        order1.getProducts().add(productRepository.findById(1L).orElseThrow());
        order1.getProducts().add(productRepository.findById(2L).orElseThrow());
        orderRepository.save(order1);

        Order order2 = new Order();
        order2.setCreatedTime(LocalDateTime.now());
        order2.getProducts().add(productRepository.findById(3L).orElseThrow());
        order2.getProducts().add(productRepository.findById(4L).orElseThrow());
        orderRepository.save(order2);
    }
}
