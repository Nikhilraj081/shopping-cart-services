package com.shoppingcart.rest.controller;

import com.shoppingcart.rest.dao.UserRepository;
import com.shoppingcart.rest.model.User;
import com.shoppingcart.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("user/{id}")
    public ResponseEntity getUser(@PathVariable("id") int id)
    {
        User user = userService.getUserById(id);
        if(user==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(user));
    }

}
