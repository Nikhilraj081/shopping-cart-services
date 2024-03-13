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

    //add product in cart
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

    //update quantity in cart

    public String updateProductQuantityInCart(int userId, int productId, int quantity)
    {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = getCartItemByCartIdAndProductId(cart.getCartId(), productId);
        Product product = productService.getProductById(productId);
       
        if(cartItem == null)
        {
            return "product is not available in cart";
        }

        if(product.getStock() == 0)
        {
            return "product is out of stock";
        }

        int newQuantity= (quantity - cartItem.getQuantity());

        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        cart.setTotalPrice(cart.getTotalPrice() +  (newQuantity * product.getSpecialPrice()));
        cart.setDiscount(cart.getDiscount() + (newQuantity * product.getDiscount()));
        cartRepository.save(cart);
        
        return "product updated";
    }

    //delete product from cart

    public String deleteProductFromCart(int userId, int productId)
    {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = getCartItemByCartIdAndProductId(cart.getCartId(), productId);
        Product product = productService.getProductById(productId);

        if(cartItem == null)
        {
            return "product is not available in cart";
        }

        cart.setTotalPrice(cart.getTotalPrice() - (cartItem.getQuantity() * product.getSpecialPrice()));
        cart.setDiscount(cart.getDiscount() - (cartItem.getQuantity() * product.getDiscount()));

        cartItemRepository.deleteById(cartItem.getCartItemId());
        cartRepository.save(cart);

        return "product deleted";
    }

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
