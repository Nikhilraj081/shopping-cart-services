package com.shoppingcart.rest.shoppingcartservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.OrderRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Order;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getOrderById(int id) throws ResourceNotFoundException
    {
        Order order = orderRepository.findById(id);
        if(order != null)
        {
            return order;
        }

        throw new ResourceNotFoundException("order not found with id: "+id);
 
    }

    public Order setOrder(Order order)
    {
        Order newOrder = null;
        if(order!=null)
        {
            newOrder = orderRepository.save(order);
        }
        return newOrder;
    }

}
