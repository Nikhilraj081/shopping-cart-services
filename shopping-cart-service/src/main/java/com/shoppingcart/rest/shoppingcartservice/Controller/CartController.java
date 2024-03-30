package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.CartItem;
import com.shoppingcart.rest.shoppingcartservice.Services.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable("userId") int userId) throws ResourceNotFoundException
    {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(cart); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        Cart cart = cartService.getCartById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cart);  
    }

    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<?> addProductToCart(@Valid @PathVariable("userId") int userId, @PathVariable("productId") int productId) throws ResourceNotFoundException, ApiException
    {
        CartItem cartItem = cartService.addProductToCart(userId, productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItem); 
    }

    @PutMapping("/user/{userId}/product/{productId}/quantity/{quantity}/update")
    public ResponseEntity<?> updateProductQuantityInCart(@Valid @PathVariable("userId") int userId, @PathVariable("productId") int productId, @PathVariable("quantity") int quantity) throws ResourceNotFoundException, ApiException
    {
       CartItem cartItem = cartService.updateProductQuantityInCart(userId, productId, quantity);
        return ResponseEntity.status(HttpStatus.OK).body(cartItem);
    }

    @DeleteMapping("/user/{userId}/product/{productId}/delete")
    public ResponseEntity<?> deteleProductFromCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) throws ResourceNotFoundException, ApiException
    {
        Cart cart = cartService.deleteProductFromCart(userId, productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cart);
    }
}
