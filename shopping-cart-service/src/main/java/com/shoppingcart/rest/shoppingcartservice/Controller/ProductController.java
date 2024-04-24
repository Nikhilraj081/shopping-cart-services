package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import com.shoppingcart.rest.shoppingcartservice.Payload.ProductDto;
import com.shoppingcart.rest.shoppingcartservice.Services.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ModelMapper modelMapper;

   

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct() throws ResourceNotFoundException
    {
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        List<ProductDto> product = modelMapper.map(productService.getAllProduct(),listType);
        return ResponseEntity.status(HttpStatus.OK).body(product);
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        ProductDto product = modelMapper.map(productService.getProductById(id),ProductDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getProductBycategory(@PathVariable("category") String category) throws ResourceNotFoundException
    {
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        List<ProductDto> product = modelMapper.map(productService.getProductByCategory(category),listType);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/subcategory/{category}")
    public ResponseEntity<?> getProductBySubCategory(@PathVariable("category") String category) throws ResourceNotFoundException
    {
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        List<ProductDto> product = modelMapper.map(productService.getProductBySubCategory(category), listType);
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
    public ResponseEntity<?> searchProduct(@PathVariable("keyword") String keyword) throws ResourceNotFoundException
    {
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        List<ProductDto> product = modelMapper.map(productService.searchByName(keyword), listType);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    

}
