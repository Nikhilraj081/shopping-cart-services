package com.shoppingcart.rest.shoppingcartservice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    private double star;
    @ManyToOne
    @JsonBackReference(value = "productreview-product")
    private Product product;
    @ManyToOne
    @JsonBackReference(value = "productreview-user")
    private User user;

    public ProductReview(int id, String comment, double star, Product product, User user) {
        this.id = id;
        this.comment = comment;
        this.star = star;
        this.product = product;
        this.user = user;
    }

    public ProductReview() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getStar() {
        return star;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
