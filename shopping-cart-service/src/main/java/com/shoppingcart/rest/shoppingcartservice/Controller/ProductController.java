package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @Value("${image.path}")
    private String path;

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

    @PostMapping("/seller/{sellerId}")
    public ResponseEntity<?> seProduct(@RequestParam("image") MultipartFile[] image, @RequestParam("productData") String productData)
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

        // Product newProduct = productService.setProduct(product);
        // return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

        for (MultipartFile multipartFile : image) {
            System.out.println(multipartFile.getOriginalFilename());
            
        }

        System.out.println(product.getProductName());


        return ResponseEntity.status(HttpStatus.OK).body("done");
    }

}
