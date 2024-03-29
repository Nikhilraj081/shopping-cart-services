package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    public Seller findById(int id);

    public Seller findBySellerEmailId(String emailId);

    public Seller findBySellerMobileNo(String mobileNo);
}
