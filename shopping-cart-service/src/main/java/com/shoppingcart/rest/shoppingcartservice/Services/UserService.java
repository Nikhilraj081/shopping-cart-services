package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.UserRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//Retrieve user details by id
    public User getUserById(int id) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id);
        if(user!=null)
        {
            return user;
        }

        throw new ResourceNotFoundException("user not found with id: "+ id);
    }

    public User SetUser(User user)
    {
        User newuser = null;
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

            newuser = userRepository.save(user);
            
        }
        return newuser;
    }

    public User UpdateUser(User user) throws ResourceNotFoundException
    {
        if(getUserById(user.getUserId())!=null)
        {
            return userRepository.save(user);
        } 
       throw new ResourceNotFoundException("user not found with id: "+ user.getUserId());
    }


}
