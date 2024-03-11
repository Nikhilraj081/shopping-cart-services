package com.shoppingcart.rest.shoppingcartservice.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.rest.shoppingcartservice.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    public List<Cart> findByUserUserId(int userId);
}
