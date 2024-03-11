package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.CartRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart getCartById(int userId)
    {
        return cartRepository.findByUserUserId(userId);
    }

    public Cart setCart(Cart cart)
    {
        if(cart!=null)
        {
            return cartRepository.save(cart);
        }
        return null;
    }

}
