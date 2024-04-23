package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Services.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @Autowired
    private ObjectMapper mapper;

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

    @PostMapping("/seller/{sellerId}/add")
    public ResponseEntity<?> seProduct(@Valid @PathVariable("sellerId") int sellerId, @RequestParam("image") MultipartFile[] image, @RequestParam("productData") String productData) throws IOException, ResourceNotFoundException
    {
        //convert string to json
        Product product = null;
        try {
            product = mapper.readValue(productData, Product.class);
        } catch (JsonMappingException e) {
           
            e.printStackTrace();
        } catch (JsonProcessingException e) {
           
            e.printStackTrace();
        }

        Product newProduct = productService.setProduct(sellerId, product, image);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchProduct(@PathVariable("keyword") String keyword) throws ResourceNotFoundException {

        List<Product> product = productService.searchByName(keyword);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    

}
