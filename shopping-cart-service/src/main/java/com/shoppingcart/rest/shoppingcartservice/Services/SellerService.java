package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.SellerRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.Seller;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller getSellerById(int id)
    {
       return sellerRepository.findById(id);
    }

    public Seller setSeller(Seller seller)
    {
        if(seller!=null)
        {
            return sellerRepository.save(seller);
        }
        return null;
    }
}
