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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty(message = "Product name should not be empty")
    private String productName;

    @NotEmpty(message = "Product category should not be empty")
    private String productCategory;

    @NotEmpty(message = "Product sub category should not be empty")
    private String productSubCategory;

    @NotNull(message = "Product price should not be null")
    private double price;

    @NotNull(message = "Product stock should not be null")
    private int stock;

    private double discount;

    private double specialPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference(value = "product-image")
    private List<ProductImage> productImage;

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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "productcolor-product")
    private List<ProductColor> color;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "productsize-product")
    private List<ProductSize> size;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "productreview-product")
    private List<ProductReview> review;

    public Product(int productId, String productName, String productCategory, String productSubCategory, double price,
            int stock, double discount, double specialPrice, List<ProductImage> productImage, Seller seller,
            List<CartItem> cartItem, List<WishListItem> wishListItem, List<Order> order, List<ProductColor> color,
            List<ProductSize> size, List<ProductReview> review) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
        this.specialPrice = specialPrice;
        this.productImage = productImage;
        this.seller = seller;
        this.cartItem = cartItem;
        this.wishListItem = wishListItem;
        this.order = order;
        this.color = color;
        this.size = size;
        this.review = review;
    }


    public Product() {
    }


    public List<ProductImage> getProductImage() {
        return productImage;
    }


    public void setProductImage(List<ProductImage> productImage) {
        this.productImage = productImage;
    }


    public List<ProductColor> getColor() {
        return color;
    }


    public void setColor(List<ProductColor> color) {
        this.color = color;
    }


    public List<ProductSize> getSize() {
        return size;
    }


    public void setSize(List<ProductSize> size) {
        this.size = size;
    }


    public List<ProductReview> getReview() {
        return review;
    }


    public void setReview(List<ProductReview> review) {
        this.review = review;
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


    public String getProductSubCategory() {
        return productSubCategory;
    }


    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    
}