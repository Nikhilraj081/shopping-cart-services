package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.WishListRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;

    public WishList getWishList(int id) throws ResourceNotFoundException
    {
        WishList wishList = wishListRepository.findByUserUserId(id);

        if(wishList != null)
        {
            return wishList;
        }

        throw new ResourceNotFoundException("wishlist not found with id: "+id);
    }

    public WishList setWishList(WishList wishlist)
    {
        WishList neWishList = null;
        if(wishlist!=null)
        {
            neWishList = wishListRepository.save(wishlist);
        } 
        return neWishList;
    }

}
