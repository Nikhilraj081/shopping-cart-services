package com.shoppingcart.rest.shoppingcartservice.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.WishListRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Service
public class WishListService {

    private Logger logger = LoggerFactory.getLogger(WishListService.class);

    @Autowired
    WishListRepository wishListRepository;

    public WishList getWishList(int id) throws ResourceNotFoundException
    {
        logger.info("Retriving data from Database");
        WishList wishList = wishListRepository.findByUserUserId(id);

        if(wishList != null)
        {
            logger.info("Data retrived successfully");
            return wishList;
        }

        throw new ResourceNotFoundException("wishlist not found with id: "+id);
    }

    public WishList setWishList(WishList wishlist)
    {
        WishList neWishList = null;
        if(wishlist!=null)
        {
            logger.info("WishList created ");
            neWishList = wishListRepository.save(wishlist);
        } 
        return neWishList;
    }

}
