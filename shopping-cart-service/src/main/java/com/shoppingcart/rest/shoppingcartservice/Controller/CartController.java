package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Services.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable("userId") int userId)
    {
        List<Cart> cart = cartService.getCartById(userId);
        if(cart!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cart not found");
        
    }

    @PostMapping("/user/cart")
    public ResponseEntity<?> setCart(@RequestBody Cart cart)
    {
        Cart cartDetails = cartService.setCart(cart);
        if(cartDetails!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("cart created");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("invalid body");

    }

}
