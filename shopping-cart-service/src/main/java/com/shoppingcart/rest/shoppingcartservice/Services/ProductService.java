package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.ProductRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct()
    {
        return productRepository.findAll();
    }

    public Product setProduct(Product product)
    {
        if(product!=null)
        {
            return productRepository.save(product);
        }
        return null;
    }
}