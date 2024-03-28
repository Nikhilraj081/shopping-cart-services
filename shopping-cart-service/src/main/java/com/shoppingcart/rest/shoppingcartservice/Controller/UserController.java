package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.util.List;

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
import com.shoppingcart.rest.shoppingcartservice.Model.Address;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Services.UserService;

import jakarta.validation.Valid;

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

    @GetMapping("{id}/address")
    public ResponseEntity <?> getUserAddress(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        List<Address> address = userService.getAddress(id);

        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @PostMapping("/{id}/add/address")
    public ResponseEntity<?> setUserAddress(@Valid @RequestBody List<Address> address , @PathVariable("id") int id) throws ResourceNotFoundException
    {
        List<Address> newAddress = userService.setAddress(address, id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newAddress);
    }

    @PutMapping("user/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user) throws ResourceNotFoundException
    {
        User newUser = userService.UpdateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }


}
