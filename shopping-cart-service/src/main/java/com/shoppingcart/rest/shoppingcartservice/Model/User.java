package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userMobileNo;
    private String userEmailId;
    private String userPassword;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Cart> cart;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Order> order;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Address> address;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<WishList> wishList;

    public User(int userId, String userName, String userMobileNo, String userEmailId, String userPassword, List<Cart> cart,
           List<Order> order, List<Address> address, List<WishList> wishList) {
        this.userId = userId;
        this.userName = userName;
        this.userMobileNo = userMobileNo;
        this.userEmailId = userEmailId;
        this.userPassword = userPassword;
        this.cart = cart;
        this.order = order;
        this.address = address;
        this.wishList = wishList;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<WishList> getWishList() {
        return wishList;
    }

    public void setWishList(List<WishList> wishList) {
        this.wishList = wishList;
    }

}