package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Order;
import com.shoppingcart.rest.shoppingcartservice.Services.OrderService;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping("/order")
    public ResponseEntity<?> setOrder(@RequestBody Order order)
    {
        Order orderDetails = orderService.setOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDetails);
    }

}
