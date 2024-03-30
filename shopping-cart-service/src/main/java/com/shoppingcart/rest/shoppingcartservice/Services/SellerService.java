package com.shoppingcart.rest.shoppingcartservice.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Configuration.Constants;
import com.shoppingcart.rest.shoppingcartservice.Dao.SellerRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Seller;
import com.shoppingcart.rest.shoppingcartservice.Model.User;

@Service
public class SellerService {

    private Logger logger = LoggerFactory.getLogger(SellerService.class);

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserService userService;

    public Seller getSellerById(int id) throws ResourceNotFoundException
    {
        logger.info("Retriving data from database");
        Seller seller = sellerRepository.findById(id);
        if(seller != null)
        {
            logger.info("Data retrived successfully");
            return seller;
        }
        throw new ResourceNotFoundException("seller not found with id: "+id);
    }

    public Seller setSeller(Seller seller) throws ApiException
    {
        if(sellerRepository.findBySellerEmailId(seller.getSellerEmailId())!=null)
        {
            throw new ApiException("Seller already exist with email id: "+ seller.getSellerEmailId());
        }

        if(sellerRepository.findBySellerMobileNo(seller.getSellerMobileNo())!=null)
        {
            throw new ApiException("Seller already exist with mobile No: "+ seller.getSellerMobileNo());
        }

        Seller newsSeller = sellerRepository.save(seller);
        logger.info("Seller created ");

        User user = new User();
        user.setUserEmailId(seller.getSellerEmailId());
        user.setUserMobileNo(seller.getSellerMobileNo());
        user.setUserName(seller.getSellerName());
        user.setUserPassword(seller.getSellerPassword());
        
        logger.info("Creating seller credential");
        userService.setUser(user, Constants.SELLER_ROLE);
        return newsSeller;
    }
}
