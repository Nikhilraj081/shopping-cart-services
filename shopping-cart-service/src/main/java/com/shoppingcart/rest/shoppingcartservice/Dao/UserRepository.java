package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.User;


@Repository
public interface UserRepository extends JpaRepository <User,Integer> {
    
    public User findById(int id);

}
