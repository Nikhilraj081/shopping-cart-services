package com.shoppingcart.rest.shoppingcartservice.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.rest.shoppingcartservice.Model.WishListItem;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem,Integer> {

    

}
