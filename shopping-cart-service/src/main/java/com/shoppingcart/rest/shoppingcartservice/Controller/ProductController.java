package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct()
    {
        List<Product> product = productService.getAllProduct();
        if(product!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
    }

    @PostMapping
    public ResponseEntity<?> seProduct(@RequestBody Product product)
    {
        Product productDetails = productService.setProduct(product);
        if(productDetails!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("product created");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("invalid product");
    }


}
