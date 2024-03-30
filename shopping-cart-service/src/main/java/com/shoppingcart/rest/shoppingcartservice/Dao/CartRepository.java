package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.rest.shoppingcartservice.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    public Cart findByUserUserId(int userId);

    public Cart findById(int id);
}
