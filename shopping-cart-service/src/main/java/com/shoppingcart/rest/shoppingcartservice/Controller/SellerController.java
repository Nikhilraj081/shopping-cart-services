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

import com.shoppingcart.rest.shoppingcartservice.Model.Seller;
import com.shoppingcart.rest.shoppingcartservice.Services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeller(@PathVariable("id") int id)
    {
       Seller seller = sellerService.getSellerById(id);
       if(seller!=null)
       {
            return ResponseEntity.status(HttpStatus.OK).body(seller);
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seller not found");
    }

    @PostMapping("/seller")
    public ResponseEntity<?> setSeller(@RequestBody Seller seller)
    {
        Seller sellerDetails = sellerService.setSeller(seller);
        if(sellerDetails!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("seller created");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Invalid body");
    }
}
