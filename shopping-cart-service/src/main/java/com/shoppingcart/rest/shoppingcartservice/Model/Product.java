package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productCategory;
    private double price;
    @ManyToOne
    @JsonBackReference
    private Seller seller;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Cart> cart;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<WishList> wishList;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Order> order;

    public Product(int productId, String productName, String productCategory, double price, Seller seller,
            List<Cart> cart, List<WishList> wishList, List<Order> order) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.seller = seller;
        this.cart = cart;
        this.wishList = wishList;
        this.order = order;
    }


    public Product() {
    }


    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getProductCategory() {
        return productCategory;
    }


    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public Seller getSeller() {
        return seller;
    }


    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    public List<Cart> getCart() {
        return cart;
    }


    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }


    public List<WishList> getWishList() {
        return wishList;
    }


    public void setWishList(List<WishList> wishList) {
        this.wishList = wishList;
    }


    public List<Order> getOrder() {
        return order;
    }


    public void setOrder(List<Order> order) {
        this.order = order;
    }

    

}