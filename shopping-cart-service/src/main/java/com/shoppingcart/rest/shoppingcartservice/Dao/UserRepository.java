package com.shoppingcart.rest.shoppingcartservice.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.User;



@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository <User,Integer>  {
    
    public User findById(int id);

    Optional<User> findByUserEmailId(String userEmailId);

    public User findByUserMobileNo(String mobileNo);

}
