package com.shoppingcart.rest.shoppingcartservice.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.shoppingcart.rest.shoppingcartservice.Dao.OrderRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.CartItem;
import com.shoppingcart.rest.shoppingcartservice.Model.Order;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    public Order getOrderById(int id) throws ResourceNotFoundException
    {
        Order order = orderRepository.findById(id);
        if(order != null)
        {
            return order;
        }

        throw new ResourceNotFoundException("order not found with id: "+id);
 
    }

    public List<Order> createOrder(int userId, int cartId) throws ResourceNotFoundException, ApiException
    {
       
        if(userService.getUserById(userId) != null && cartService.getCartById(cartId) != null)
        {
            Cart cart = cartService.getCartById(cartId);
            List<CartItem> cartItem = cart.getCartItem();
            List<Order> newOrder = new ArrayList<Order>();

            for (CartItem item : cartItem) {
                Order order = new Order();
                order.setDate(Calendar.getInstance());
                order.setProduct(item.getProduct());
                order.setPrice(item.getProduct().getSpecialPrice());
                order.setQuantity(item.getQuantity());
                order.setUser(userService.getUserById(userId));

                orderRepository.save(order); 

                cartService.deleteProductFromCart(userId, order.getProduct().getProductId());
                newOrder.add(order);
            }
            return newOrder;
        } 

        throw new ResourceNotFoundException("user or cart not found with user id: "+userId+ "or cart id: "+cartId);
    }

}
