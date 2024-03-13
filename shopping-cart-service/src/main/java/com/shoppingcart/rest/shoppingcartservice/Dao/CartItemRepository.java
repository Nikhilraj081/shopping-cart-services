package com.shoppingcart.rest.shoppingcartservice.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    public CartItem findById(int id);

    public List<CartItem> findByCartCartId(int id);

    public CartItem findByCartCartIdAndProductProductId(int cartId, int productId);

}
