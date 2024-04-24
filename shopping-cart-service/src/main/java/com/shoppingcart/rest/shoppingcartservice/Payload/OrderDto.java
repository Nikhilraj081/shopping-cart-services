package com.shoppingcart.rest.shoppingcartservice.Payload;

import java.util.Calendar;

public class OrderDto {

    private long orderId;

    private Calendar date;

    private ProductDto product;

    private int quantity;

    private double price;

    public OrderDto(long orderId, Calendar date, ProductDto product, int quantity, double price) {
        this.orderId = orderId;
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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
