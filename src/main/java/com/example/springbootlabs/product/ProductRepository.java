package com.example.springbootlabs.product;

import com.example.springbootlabs.comment.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p" +
        " left join fetch p.comments")
    List<Comment> findAllProducts(Pageable page);
}
