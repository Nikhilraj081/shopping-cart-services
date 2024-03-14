package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.ProductRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() throws ResourceNotFoundException
    {
        List<Product> product = productRepository.findAll();
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("There is no any product");
    }

    public Product getProductById(int id) throws ResourceNotFoundException
    {
        Product product = productRepository.findById(id);
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("product not found with id: "+ id);
    }

    public List<Product> getProductByCategory(String category) throws ResourceNotFoundException
    {
        List<Product> product = productRepository.findByProductCategory(category);
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("product not found with category: "+category);
    }

    public List<Product> getProductBySubCategory(String subCategory) throws ResourceNotFoundException
    {
        List<Product> product = productRepository.findByProductSubCategory(subCategory);
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("product not found with subcategory: "+subCategory);
    }

    public Product setProduct(Product product)
    {
        Product newProduct = null;
        product.setSpecialPrice(product.getPrice() - product.getDiscount());
        if(product!=null)
        {
            newProduct = productRepository.save(product);
        }
        return newProduct;
    }
}
