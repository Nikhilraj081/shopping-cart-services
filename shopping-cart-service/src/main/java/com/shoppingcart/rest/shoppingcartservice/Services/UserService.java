package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.RoleRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.UserRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Address;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.Role;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


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

//Retrive User address
    public List<Address> getAddress(int id) throws ResourceNotFoundException
    {
        User user = getUserById(id);
        List<Address> address = user.getAddress();
        return address;
    }

    public List<Address> setAddress(List<Address> address, int id) throws ResourceNotFoundException
    {
        User user = getUserById(id);
        address.forEach(items -> items.setUser(user));
        user.setAddress(address);
        userRepository.save(user);

        return user.getAddress();
    }

    public User setUser(User user, String role) throws ApiException
    {
        if(role == "user" || role == "seller" )
        {
            Role newRole = new Role();
            newRole = roleRepository.findByRole(role);

            Set userRole = new HashSet<>();
            userRole.add(newRole);
            user.setRoles(userRole);
            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        }
        else{
            throw new ApiException("User role is invalid");
        }

        if(!userRepository.findByUserEmailId(user.getUserEmailId()).isEmpty() )
        {
            throw new ApiException("User already exist with email id: "+ user.getUserEmailId());
        }

        if(userRepository.findByUserMobileNo(user.getUserMobileNo())!=null)
        {
            throw new ApiException("User already exist with mobile No: "+user.getUserMobileNo());
        }

        if(role == "seller")
        {
            User seller = userRepository.save(user);
            return seller;
        }

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
