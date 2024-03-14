package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findById(int id);

    public List<Product> findByProductCategory(String productCategory);

    public List<Product> findByProductSubCategory(String subCategory);

}
