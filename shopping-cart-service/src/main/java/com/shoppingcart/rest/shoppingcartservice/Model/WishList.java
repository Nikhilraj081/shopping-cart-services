package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wishListId;

    @OneToMany(mappedBy = "wishList")
    @JsonManagedReference(value = "wishlistitem-wishlist")
    private List<WishListItem> wishListItem;
    
    @OneToOne
    @JsonBackReference(value = "wishlist-user")
    private User user;

    public WishList(int wishListId, List<WishListItem> wishListItem, User user) {
        this.wishListId = wishListId;
        this.wishListItem = wishListItem;
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

    public List<WishListItem> getWishListItem() {
        return wishListItem;
    }

    public void setWishListItem(List<WishListItem> wishListItem) {
        this.wishListItem = wishListItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 
}