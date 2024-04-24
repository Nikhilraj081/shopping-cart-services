package com.shoppingcart.rest.shoppingcartservice.Payload;

import java.util.List;
import com.shoppingcart.rest.shoppingcartservice.Model.ProductImage;
import com.shoppingcart.rest.shoppingcartservice.Model.ProductReview;
import com.shoppingcart.rest.shoppingcartservice.Model.Seller;

public class ProductDto {

    
    private int productId;
    
    private String productName;

    private String productCategory;

    private String productSubCategory;

    private double price;

    private int stock;

    private double discount;

    private double specialPrice;

    private List<ProductImage> productImage;
   
    private String color;

    private String size;

    private List<ProductReview> review;

    public ProductDto(int productId, String productName, String productCategory, String productSubCategory,
            double price, int stock, double discount, double specialPrice, List<ProductImage> productImage,
            String color, String size, List<ProductReview> review) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
        this.specialPrice = specialPrice;
        this.productImage = productImage;
        this.color = color;
        this.size = size;
        this.review = review;
    }

    public ProductDto() {
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

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public List<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<ProductImage> productImage) {
        this.productImage = productImage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<ProductReview> getReview() {
        return review;
    }

    public void setReview(List<ProductReview> review) {
        this.review = review;
    }
}
