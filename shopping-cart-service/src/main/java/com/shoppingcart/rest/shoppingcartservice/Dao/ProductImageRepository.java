package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.rest.shoppingcartservice.Model.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

}
