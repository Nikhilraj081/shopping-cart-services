package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wishListId;
    @OneToMany(mappedBy = "wishList")
    private List<Product> product;
   @OneToOne
    private User user;


    public WishList(int wishListId, List<Product> product, User user) {
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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    
}
