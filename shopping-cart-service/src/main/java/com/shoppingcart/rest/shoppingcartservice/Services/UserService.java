package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


//Retrieve user details by id
    public User getUserById(int id) throws ResourceNotFoundException
    {
        logger.info("Retriving data from Database");

        User user = userRepository.findById(id);
        if(user!=null)
        {
            logger.info("Data retrived successfully");
            return user;
        }

        throw new ResourceNotFoundException("user not found with id: "+ id);
    }

//Retrive User address
    public List<Address> getAddress(int userId) throws ResourceNotFoundException
    {
        logger.info("Retriving data from Database");

        User user = getUserById(userId);
        List<Address> address = user.getAddress();
        if(address!=null)
        {
            logger.info("Data retrived successfully");
            return address;
        }
        
        throw new ResourceNotFoundException("Address not found for user id: "+userId);
        
    }

    public List<Address> setAddress(List<Address> address, int userId) throws ResourceNotFoundException
    {
        User user = getUserById(userId);
        address.forEach(items -> items.setUser(user));
        user.setAddress(address);
        userRepository.save(user);

        logger.info("Address added to Database");
        return user.getAddress();
    }

    public User setUser(User user, String role) throws ApiException
    {
        if(role == "user" || role == "seller" )
        {
            logger.info("Setting roles");
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
            logger.info("Added seller info in Database");

            return seller;
        }

        User newuser = null;
        if(user!=null)
        {
            logger.info("Creating cart for user ");
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);

            logger.info("Creating WishList for users");
            WishList wishlist = new WishList();
            wishlist.setUser(user);
            user.setWishList(wishlist);

            newuser = userRepository.save(user);
            logger.info("User created successfully");
        }
        return newuser;
    }

    public User UpdateUser(User user) throws ResourceNotFoundException
    {
        if(getUserById(user.getUserId())!=null)
        {
            logger.info("Updating user information");
            return userRepository.save(user);
        } 
       throw new ResourceNotFoundException("user not found with id: "+ user.getUserId());
    }


}
