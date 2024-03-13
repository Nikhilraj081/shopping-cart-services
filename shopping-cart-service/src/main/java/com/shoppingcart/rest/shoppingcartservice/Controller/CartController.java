package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        Cart cart = cartService.getCartByUserId(userId);
        if(cart!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cart not found");
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable("id") int id)
    {
        Cart cart = cartService.getCartById(id);
        if(cart!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cart not found");
        
    }

    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId)
    {
        String string = cartService.addProductToCart(userId, productId);
    
        return ResponseEntity.status(HttpStatus.CREATED).body(string);
        
    }

    @PutMapping("/user/{userId}/product/{productId}/quantity/{quantity}/update")
    public ResponseEntity<?> updateProductQuantityInCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId, @PathVariable("quantity") int quantity)
    {
        String string = cartService.updateProductQuantityInCart(userId, productId, quantity);
        return ResponseEntity.status(HttpStatus.OK).body(string);
    }

    @DeleteMapping("/user/{userId}/product/{productId}/delete")
    public ResponseEntity<?> deteleProductFromCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId)
    {
        String string = cartService.deleteProductFromCart(userId, productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(string);
    }
}
