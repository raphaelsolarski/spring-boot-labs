package com.example.springbootlabs.product;

import com.example.springbootlabs.comment.Comment;
import com.example.springbootlabs.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
//@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuID;
    private String productName;
    private Producer producer;

/*    @OneToMany
    @JoinColumn(name = "product_id")*/

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    public Product(String productName, Producer producer, Set<Comment> comments) {
        this.uuID = UUID.randomUUID();
        this.productName = productName;
        this.producer = producer;
        this.comments = comments;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(uuID, product.uuID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuID);
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
