package com.shoppingcart.rest.shoppingcartservice.Payload;

import java.util.List;

import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Model.WishListItem;

public class WishListDto {

    private List<WishListItem> wishListItem;
    
    private User user;

    public WishListDto(List<WishListItem> wishListItem, User user) {
        this.wishListItem = wishListItem;
        this.user = user;
    }

    public WishListDto() {
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
