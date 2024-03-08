package com.shoppingcart.rest.shoppingcartservice.Model;


import java.util.List;

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
    @OneToMany(mappedBy = "seller")
    private List<Product> product;
    
    public Seller(int sellerId, String sellerName, String sellerAddress, List<Product> product) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.product = product;
    }

    public Seller() {
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
