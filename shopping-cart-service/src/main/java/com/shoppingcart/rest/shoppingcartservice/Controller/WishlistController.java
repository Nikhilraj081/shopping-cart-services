package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;
import com.shoppingcart.rest.shoppingcartservice.Model.WishListItem;
import com.shoppingcart.rest.shoppingcartservice.Services.WishListService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/wishlists")
public class WishlistController {

    @Autowired
    WishListService wishListService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getWishListByUserId(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        WishList wishList = wishListService.getWishList(id);
        return ResponseEntity.status(HttpStatus.OK).body(wishList);
    }

    @PostMapping("/user/{id}/product/{productId}")
    public ResponseEntity<?> setWishList(@PathVariable("id") int id, @PathVariable("productId") int productId)
    {
        WishListItem neWishList = wishListService.setWishList(id, productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(neWishList);  
    }

}
