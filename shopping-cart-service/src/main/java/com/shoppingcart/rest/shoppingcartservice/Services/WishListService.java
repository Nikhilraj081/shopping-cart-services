package com.shoppingcart.rest.shoppingcartservice.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.ProductRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.WishListItemRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.WishListRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;
import com.shoppingcart.rest.shoppingcartservice.Model.WishListItem;

@Service
public class WishListService {

    private Logger logger = LoggerFactory.getLogger(WishListService.class);

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    WishListItemRepository wishListItemRepository;

    @Autowired
    ProductRepository productRepository;

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

    public WishListItem setWishList(int userId, int productId)
    {
        WishList wishList = wishListRepository.findByUserUserId(userId);
        Product product = productRepository.findById(productId);

        WishListItem wishListItem = new WishListItem();
        wishListItem.setWishList(wishList);
        wishListItem.setProduct(product);
        
        wishListItemRepository.save(wishListItem);
        logger.info("WishList created ");
           
        return wishListItem;
    }

}
