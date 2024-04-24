package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Seller;
import com.shoppingcart.rest.shoppingcartservice.Payload.SellerDto;
import com.shoppingcart.rest.shoppingcartservice.Services.SellerService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeller(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        SellerDto seller = modelMapper.map(sellerService.getSellerById(id),SellerDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(seller);
    }

    @PostMapping("/register")
    public ResponseEntity<?> setSeller(@Valid @RequestBody SellerDto seller) throws ApiException
    {
        Seller newSeller = sellerService.setSeller(modelMapper.map(seller,Seller.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeller);

    }
}
