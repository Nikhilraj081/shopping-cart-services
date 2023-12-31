package com.shoppingcart.rest.dao;

import com.shoppingcart.rest.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Product findById(int id);
}
