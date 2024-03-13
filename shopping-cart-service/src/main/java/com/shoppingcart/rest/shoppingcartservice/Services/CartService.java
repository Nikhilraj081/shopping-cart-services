package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.CartItemRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.CartRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.ProductRepository;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.CartItem;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Model.User;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public Cart getCartByUserId(int userId)
    {
        return cartRepository.findByUserUserId(userId);
    }

    public Cart setCart(Cart cart)
    {
        if(cart!=null)
        {
            return cartRepository.save(cart);
        }
        return null;
    }

    public String addProductToCart(int userId, int productId)
    {

        Cart cart = getCartByUserId(userId);
        CartItem cartItem = cartItemRepository.findByCartCartIdAndProductProductId(getCartByUserId(userId).getCartId(), productId);
        Product product = productService.getProductById(productId);
        if(cartItem!=null)
        {
            return "product already exists in cart";
        }

        if(product.getStock() == 0)
        {
            return "product is out of stock";
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setCart(cart);
        newCartItem.setProduct(product);
        newCartItem.setQuantity(1);

        cartItemRepository.save(newCartItem);
        
        cart.setTotalPrice(cart.getTotalPrice() + (product.getSpecialPrice() * 1));
        cart.setDiscount(cart.getDiscount() + product.getDiscount());
        cartRepository.save(cart);

        return "added product to cart";
    }

    // public CartItem setCartItem(int userId, CartItem cartItem)
    // {
    //    Double totalPrice = 0.0;

    //    if(getCartByUserId(userId)!=null && cartItem!=null)
    //    {
    //       cartItem.setCart(getCartByUserId(userId));
    //       cartItem.setProduct(productService.getProductById(cartItem.getProduct().getProductId()));

    //       if(getCartItemByCartIdAndProductId(getCartByUserId(userId).getCartId(), cartItem.getProduct().getProductId())!=null)
    //       {
    //         System.out.println("under condition");
    //         cartItem.setQuantity(getCartItemByCartIdAndProductId(userId, cartItem.getProduct().getProductId()).getQuantity() + 1);
    //       }
    //       cartItem.setQuantity(1);

    //       CartItem cartitemDetails = cartItemRepository.save(cartItem);

    //       totalPrice = (getCartByUserId(userId).getTotalPrice() + cartitemDetails.getProduct().getPrice())*cartitemDetails.getQuantity();

    //       Cart cart = cartRepository.findByUserUserId(userId);
    //       cart.setTotalPrice(totalPrice);

    //       cartRepository.save(cart);

    //       return cartitemDetails;
          
    //    }
    //   Cart cart = new Cart();
    //   cart.setUser(userService.getUserById(userId));
    //   cartRepository.save(cart);

    //   cartItem.setCart(getCartByUserId(userId));
    //   cartItem.setProduct(productService.getProductById(cartItem.getProduct().getProductId()));
    //   CartItem cartitemDetails = cartItemRepository.save(cartItem);

    //   totalPrice = (getCartByUserId(userId).getTotalPrice() + cartitemDetails.getProduct().getPrice())*cartitemDetails.getQuantity();

    //   Cart cartDetails = cartRepository.findByUserUserId(userId);
    //   cartDetails.setTotalPrice(totalPrice);

    //   cartRepository.save(cartDetails);

    //   return cartitemDetails;
    // }

    public Cart getCartById(int Id)
    {
        return cartRepository.findById(Id);
    }

    public CartItem getCartItemById(int id)
    {
        return cartItemRepository.findById(id);
    }

    public CartItem getCartItemByCartIdAndProductId(int cartId, int productId)
    {
        return cartItemRepository.findByCartCartIdAndProductProductId(cartId, productId);
    }

}
