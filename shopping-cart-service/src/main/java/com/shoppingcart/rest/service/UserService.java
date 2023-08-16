package com.shoppingcart.rest.service;

import com.shoppingcart.rest.dao.UserRepository;
import com.shoppingcart.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //get user by id
    public User getUserById(int id)
    {
        return userRepository.findById(id);
    }

    //save user registration data
    public User setUser(User user)
    {
        return userRepository.save(user);
    }

    //update user data
    public User updateUserData(User user, int id)
    {
        if(getUserById(id)!=null)
        {
            return userRepository.save(user);
        }
        return null;
    }
}
