package com.shoppingcart.rest.controller;

import com.shoppingcart.rest.model.Seller;
import com.shoppingcart.rest.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/seller/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable int id)
    {
       Seller seller = sellerService.getSellerById(id);
       if(seller==null)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.status(HttpStatus.OK).body(seller);
    }

    @PostMapping("/seller/register")
    public ResponseEntity<?> registerSeller(@RequestBody Seller seller)
    {
        Seller sellerDetails = sellerService.setSeller(seller);

        if(sellerDetails == null)
        {
           return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/seller/update/{id}")
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller, @PathVariable("id") int id)
    {
        Seller sellerDetails = sellerService.updateSellerData(seller, id);
        System.out.println(sellerDetails);
        if(sellerDetails==null)
        {
           return ResponseEntity.status(HttpStatus.ACCEPTED).body("Id is not valid or something wrong in body");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Seller data updated successfully");
    }
}
