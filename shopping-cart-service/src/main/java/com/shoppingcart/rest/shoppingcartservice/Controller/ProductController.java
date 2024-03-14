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

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct() throws ResourceNotFoundException
    {
        List<Product> product = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(product);
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        Product product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getProductBycategory(@PathVariable("category") String category) throws ResourceNotFoundException
    {
        List<Product> product = productService.getProductByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/subcategory/{category}")
    public ResponseEntity<?> getProductBySubCategory(@PathVariable("category") String category) throws ResourceNotFoundException
    {
        List<Product> product = productService.getProductBySubCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(product); 
    }

    @PostMapping
    public ResponseEntity<?> seProduct(@RequestBody Product product)
    {
        Product productDetails = productService.setProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDetails);
    }


}
