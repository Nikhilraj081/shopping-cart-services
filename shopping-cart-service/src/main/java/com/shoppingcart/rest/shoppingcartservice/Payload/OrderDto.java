package com.shoppingcart.rest.shoppingcartservice.Payload;

import java.util.Calendar;

import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Model.User;

public class OrderDto {

    private long orderId;

    private User user;

    private Calendar date;

    private Product product;

    private int quantity;

    private double price;

    public OrderDto(long orderId, User user, Calendar date, Product product, int quantity, double price) {
        this.orderId = orderId;
        this.user = user;
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDto() {
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

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
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
