package com.shoppingcart.rest.dao;

import com.shoppingcart.rest.model.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
    public Seller findById(int id);
}
