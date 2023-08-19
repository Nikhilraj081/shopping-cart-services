package com.shoppingcart.rest.controller;

import com.shoppingcart.rest.model.Product;
import com.shoppingcart.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id)
    {

        Product product = productService.getProductById(id);
        if(product == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts()
    {
        List<Product> product = productService.getAllProduct();
        if(product == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
