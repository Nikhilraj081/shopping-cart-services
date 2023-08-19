package com.shoppingcart.rest.service;

import com.shoppingcart.rest.dao.ProductRepository;
import com.shoppingcart.rest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product getProductById(int id)
    {
        return productRepository.findById(id);
    }
    public List<Product> getAllProduct()
    {
        return (List<Product>) productRepository.findAll();
    }
}
