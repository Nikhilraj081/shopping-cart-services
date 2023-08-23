package com.shoppingcart.rest.dao;

import com.shoppingcart.rest.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findById(int id);

    public Optional<User> findByUserEmailId(String email);


}
