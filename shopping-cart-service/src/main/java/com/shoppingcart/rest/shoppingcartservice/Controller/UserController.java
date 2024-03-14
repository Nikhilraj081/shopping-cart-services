package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/user")
    public ResponseEntity <?> SetUser(@RequestBody User user)
    {
        User newUser = userService.SetUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUser);
    }

    @PutMapping("user/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) throws ResourceNotFoundException
    {
        User newUser = userService.UpdateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }

}
