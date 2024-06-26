package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.CartItem;
import com.shoppingcart.rest.shoppingcartservice.Services.CartService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/cartitem")
public class CartItemController {


    @Autowired
    CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        CartItem cart = cartService.getCartItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cart);   
    }

}
