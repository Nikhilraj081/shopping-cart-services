package com.shoppingcart.rest.shoppingcartservice.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Order;
import com.shoppingcart.rest.shoppingcartservice.Payload.OrderDto;
import com.shoppingcart.rest.shoppingcartservice.Services.OrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        OrderDto order = modelMapper.map(orderService.getOrderById(id), OrderDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping("/user/{userId}/cart/{cartId}")
    public ResponseEntity<?> createOrder(@Valid @PathVariable("userId") int userId, @PathVariable("cartId") int cartId) throws ResourceNotFoundException, ApiException
    {
        List<Order> orderDetails = orderService.createOrder(userId, cartId);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDetails);
    }

}
