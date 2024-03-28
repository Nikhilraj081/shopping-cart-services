package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.SellerRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Seller;
import com.shoppingcart.rest.shoppingcartservice.Model.User;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserService userService;

    private static final String role = "seller";

    public Seller getSellerById(int id) throws ResourceNotFoundException
    {
       Seller seller = sellerRepository.findById(id);
       if(seller != null)
       {
            return seller;
       }
       throw new ResourceNotFoundException("seller not found with id: "+id);
    }

    public Seller setSeller(Seller seller) throws ApiException
    {
        User user = new User();
        user.setUserEmailId(seller.getSellerEmailId());
        user.setUserMobileNo(seller.getSellerMobileNo());
        user.setUserName(seller.getSellerName());
        user.setUserPassword(seller.getSellerPassword());

        userService.setUser(user, role);
        
        Seller newsSeller = null;
        if(seller!=null)
        {
           newsSeller = sellerRepository.save(seller);
        }
        return newsSeller;
    }
}
