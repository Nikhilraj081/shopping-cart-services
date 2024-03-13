package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private int stock;
    private double discount;
    private double specialPrice;
    @ManyToOne
    @JsonBackReference(value = "product-seller")
    private Seller seller;
    @OneToMany(mappedBy = "product")//, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JsonBackReference(value = "cartitem-product")
    private List<CartItem> cartItem;
    @OneToMany(mappedBy = "product")
    @JsonBackReference(value = "wishlist-product")
    private List<WishListItem> wishListItem;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "order-product")
    private List<Order> order;

    
    public Product(int productId, String productName, String productCategory, double price, int stock, double discount,
            double specialPrice, Seller seller, List<CartItem> cartItem, List<WishListItem> wishListItem,
            List<Order> order) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
        this.specialPrice = specialPrice;
        this.seller = seller;
        this.cartItem = cartItem;
        this.wishListItem = wishListItem;
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

    public List<Order> getOrder() {
        return order;
    }


    public void setOrder(List<Order> order) {
        this.order = order;
    }


    public List<CartItem> getCartItem() {
        return cartItem;
    }


    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }


    public List<WishListItem> getWishListItem() {
        return wishListItem;
    }


    public void setWishListItem(List<WishListItem> wishListItem) {
        this.wishListItem = wishListItem;
    }

    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }


    public double getDiscount() {
        return discount;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public double getSpecialPrice() {
        return specialPrice;
    }


    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    
}