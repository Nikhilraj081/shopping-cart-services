package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.WishListRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;

    public List<WishList> getWishList(int id)
    {
        return wishListRepository.findByUserUserId(id);
    }

    public WishList setWishList(WishList wishlist)
    {
        if(wishlist!=null)
        {
            return wishListRepository.save(wishlist);
        } 
        return null;
    }

}
