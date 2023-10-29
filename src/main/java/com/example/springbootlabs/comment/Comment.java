package com.example.springbootlabs.comment;

import com.example.springbootlabs.product.Producer;
import com.example.springbootlabs.product.Product;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
//@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuID;
    private String text;
    @Enumerated(EnumType.STRING)
    private CommentType commentType;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Comment(String text, CommentType commentType) {
        this.uuID = UUID.randomUUID();
        this.text = text;
        this.commentType = commentType;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuID() {
        return uuID;
    }

    public void setUuID(UUID uuID) {
        this.uuID = uuID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;
        return Objects.equals(getUuID(), comment.getUuID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuID());
    }
}
