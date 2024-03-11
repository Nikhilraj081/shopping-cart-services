package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.OrderRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.Order;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getOrderById(int id)
    {
        return orderRepository.findById(id);
 
    }

    public Order setOrder(Order order)
    {

        if(order!=null)
        {
            return orderRepository.save(order);
        }
        return null;
    }

}
