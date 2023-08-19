package com.shoppingcart.rest.service;

import com.shoppingcart.rest.dao.SellerRepository;
import com.shoppingcart.rest.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
        return sellerRepository.save(seller);
    }

    public Seller updateSellerData(Seller seller, int id)
    {
        seller.setSellerId(id);
        if(getSellerById(id) != null)
        {
            return sellerRepository.save(seller);
        }
        return null;
    }
}
