package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.rest.shoppingcartservice.Model.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    public Order findById(int id);

}
