package com.shoppingcart.rest.shoppingcartservice.Model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sellerId;
    private String sellerName;
    private String sellerAddress;
    private String sellerEmailId;
    private String sellerMobileNo;
    private String sellerPassword;
    @OneToMany(mappedBy = "seller")
    @JsonManagedReference(value = "product-seller")
    private List<Product> product;
    
    public Seller(int sellerId, String sellerName, String sellerAddress, String sellerEmailId, String sellerMobileNo,
            String sellerPassword, List<Product> product) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerEmailId = sellerEmailId;
        this.sellerMobileNo = sellerMobileNo;
        this.sellerPassword = sellerPassword;
        this.product = product;
    }

    public Seller() {
    }

    public String getSellerEmailId() {
        return sellerEmailId;
    }

    public void setSellerEmailId(String sellerEmailId) {
        this.sellerEmailId = sellerEmailId;
    }

    public String getSellerMobileNo() {
        return sellerMobileNo;
    }

    public void setSellerMobileNo(String sellerMobileNo) {
        this.sellerMobileNo = sellerMobileNo;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    

}
