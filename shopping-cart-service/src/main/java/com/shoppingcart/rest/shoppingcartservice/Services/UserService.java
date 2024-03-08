package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.UserRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.User;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//Retrieve user details by id
    public User getUserById(int id)
    {
        return userRepository.findById(id);
    }

    public User SetUser(User user)
    {
        if(user!=null)
        {
            return userRepository.save(user);
        }

        return null;
    }


}
