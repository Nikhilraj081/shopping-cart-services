package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.UserRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//Retrieve user details by id
    public User getUserById(int id)
    {
        return userRepository.findById(id);
    }

    public String SetUser(User user)
    {
        if(user!=null)
        {
            //set cart
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);

            //set wishlist
            WishList wishlist = new WishList();
            wishlist.setUser(user);
            user.setWishList(wishlist);

            userRepository.save(user);
            
            return "user added";
        }

        return "invalid body";
    }


}
