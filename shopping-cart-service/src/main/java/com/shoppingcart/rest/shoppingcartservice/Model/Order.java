package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    @ManyToOne
    @JsonBackReference(value = "order-user")
    private User user;

    @NotNull(message = "Date should not be empty")
    private Calendar date;

    @ManyToOne
    @JsonBackReference(value = "order-product")
    private Product product;

    @NotNull(message = "Quantity should not be empty")
    private int quantity;

    @NotNull(message = "Price should not be empty")
    private double price;

   
    public Order(long orderId, User user, Calendar date, Product product, int quantity, double price) {
        this.orderId = orderId;
        this.user = user;
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

}
