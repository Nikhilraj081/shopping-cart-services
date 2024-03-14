package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.SellerRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Seller;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller getSellerById(int id) throws ResourceNotFoundException
    {
       Seller seller = sellerRepository.findById(id);
       if(seller != null)
       {
            return seller;
       }
       throw new ResourceNotFoundException("seller not found with id: "+id);
    }

    public Seller setSeller(Seller seller)
    {
        Seller newsSeller = null;
        if(seller!=null)
        {
           newsSeller = sellerRepository.save(seller);
        }
        return newsSeller;
    }
}
