package com.shoppingcart.rest.shoppingcartservice.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import java.util.List;



@Repository
public interface UserRepository extends JpaRepository <User,Integer>  {
    
    public User findById(int id);

    Optional<User> findByUserEmailId(String userEmailId);

}
