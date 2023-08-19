package com.shoppingcart.rest.controller;

import com.shoppingcart.rest.model.User;
import com.shoppingcart.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<?> userRegister(@RequestBody User user)
    {
        User userDetails = userService.setUser(user);
        if(userDetails==null)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
	@GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") int id)
    {
       User userDetails = userService.updateUserData(user, id);
       if(userDetails==null)
       {
           return ResponseEntity.status(HttpStatus.ACCEPTED).body("Id is not valid or something wrong in body");
       }
       return ResponseEntity.status(HttpStatus.CREATED).body("User data updated successfully");
    }
}
