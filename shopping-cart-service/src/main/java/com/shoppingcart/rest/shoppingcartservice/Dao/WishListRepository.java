package com.shoppingcart.rest.shoppingcartservice.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    public List<WishList> findByUserUserId(int id);
}
