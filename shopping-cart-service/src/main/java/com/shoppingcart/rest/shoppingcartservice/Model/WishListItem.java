package com.shoppingcart.rest.shoppingcartservice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WishListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wishListItemId;

    @ManyToOne
    @JsonBackReference(value = "wishlistitem-wishlist")
    private WishList wishList;
    
    @ManyToOne
    private Product product;
    
    public WishListItem(int wishListItemId, WishList wishList, Product product) {
        this.wishListItemId = wishListItemId;
        this.wishList = wishList;
        this.product = product;
    }

    public WishListItem() {
    }

    public int getWishListItemId() {
        return wishListItemId;
    }

    public void setWishListItemId(int wishListItemId) {
        this.wishListItemId = wishListItemId;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
