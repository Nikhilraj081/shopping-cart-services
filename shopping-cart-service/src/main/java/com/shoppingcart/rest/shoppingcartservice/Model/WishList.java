package com.shoppingcart.rest.shoppingcartservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wishListId;
    @ManyToOne
    private Product product;
   @OneToOne
    private User user;


    public WishList(int wishListId, Product product, User user) {
        this.wishListId = wishListId;
        this.product = product;
        this.user = user;
    }

    public WishList() {
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    
}
