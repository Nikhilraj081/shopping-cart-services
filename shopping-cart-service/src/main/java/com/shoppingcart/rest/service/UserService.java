package com.shoppingcart.rest.service;

import com.shoppingcart.rest.dao.UserRepository;
import com.shoppingcart.rest.model.Role;
import com.shoppingcart.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //get user by id
    public User getUserById(int id)
    {
        return userRepository.findById(id);
    }

    //save user registration data
    public User setUser(User user)
    {
        Role role = new Role();
        role.setRoleName("user");

       Set userRole = new HashSet<>();
       userRole.add(role);
       user.setRole(userRole);

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        if(user != null)
        {
            return userRepository.save(user);
        }
        return null;
    }

    //update user data
    public User updateUserData(User user, int id)
    {
        user.setUserId(id);
        if(getUserById(id) != null)
        {
            return userRepository.save(user);
        }
        return null;
    }
}
