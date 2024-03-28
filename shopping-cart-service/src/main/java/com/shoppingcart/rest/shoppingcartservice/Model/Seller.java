package com.shoppingcart.rest.shoppingcartservice.Model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sellerId;

    @NotEmpty(message = "Seller Name should not be empty")
    private String sellerName;

    @NotEmpty(message = "Seller address should not be empty")
    private String sellerAddress;

    @Column(unique = true)
    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email should not be empty")
    private String sellerEmailId;

    @Column(unique = true)
    @NotEmpty(message = "seller Mobile no should not be empty")
    private String sellerMobileNo;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 8, max = 16, message = "Password length should be between 8 to 16 character")
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
