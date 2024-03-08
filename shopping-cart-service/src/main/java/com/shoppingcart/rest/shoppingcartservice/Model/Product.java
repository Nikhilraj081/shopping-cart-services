package com.shoppingcart.rest.shoppingcartservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productCategory;
    private double price;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private WishList wishList;

   
    public Product(int productId, String productName, String productCategory, double price, Seller seller,
            Cart cart, WishList wishList) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.seller = seller;
        this.cart = cart;
        this.wishList = wishList;
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


    public Cart getCart() {
        return cart;
    }


    public void setCart(Cart cart) {
        this.cart = cart;
    }


    public WishList getWishList() {
        return wishList;
    }


    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    

}