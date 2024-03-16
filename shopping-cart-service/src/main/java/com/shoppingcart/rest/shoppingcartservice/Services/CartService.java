package com.shoppingcart.rest.shoppingcartservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Dao.CartItemRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.CartRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.ProductRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
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
    public CartItem addProductToCart(int userId, int productId) throws ResourceNotFoundException, ApiException
    {

        Cart cart = getCartByUserId(userId);
        CartItem cartItem = cartItemRepository.findByCartCartIdAndProductProductId(getCartByUserId(userId).getCartId(), productId);
        Product product = productService.getProductById(productId);
        if(cartItem!=null)
        {
            throw new ApiException( "product already exists in cart");
        }

        if(product.getStock() == 0)
        {
            throw new ApiException("product is out of stock");
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setCart(cart);
        newCartItem.setProduct(product);
        newCartItem.setQuantity(1);

        CartItem newCartItem2 = cartItemRepository.save(newCartItem);

        cart.setTotalPrice(cart.getTotalPrice() + (product.getSpecialPrice() * 1));
        cart.setDiscount(cart.getDiscount() + product.getDiscount());
        cartRepository.save(cart);

        return newCartItem2;
    }

    //update quantity in cart

    public CartItem updateProductQuantityInCart(int userId, int productId, int quantity) throws ResourceNotFoundException, ApiException
    {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = getCartItemByCartIdAndProductId(cart.getCartId(), productId);
        Product product = productService.getProductById(productId);
       
        if(cartItem == null)
        {
            throw new ApiException( "product is not available in cart");
        }

        if(product.getStock() == 0)
        {
            throw new ApiException( "product is out of stock");
        }

        int newQuantity= (quantity - cartItem.getQuantity());

        cartItem.setQuantity(quantity);
        CartItem newCartItem = cartItemRepository.save(cartItem);

        cart.setTotalPrice(cart.getTotalPrice() +  (newQuantity * product.getSpecialPrice()));
        cart.setDiscount(cart.getDiscount() + (newQuantity * product.getDiscount()));
        cartRepository.save(cart);
        
        return newCartItem;
    }

    //delete product from cart

    public Cart deleteProductFromCart(int userId, int productId) throws ResourceNotFoundException, ApiException
    {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = getCartItemByCartIdAndProductId(cart.getCartId(), productId);
        Product product = productService.getProductById(productId);

        if(cartItem == null)
        {
            throw new ApiException( "product is not available in cart");
        }

        cart.setTotalPrice(cart.getTotalPrice() - (cartItem.getQuantity() * product.getSpecialPrice()));
        cart.setDiscount(cart.getDiscount() - (cartItem.getQuantity() * product.getDiscount()));
       
        cartItemRepository.deleteById(cartItem.getCartItemId());

        return cart;
    }

    public Cart getCartByUserId(int userId) throws ResourceNotFoundException
    {
        Cart cart =  cartRepository.findByUserUserId(userId);;
        if(cart != null)
        {
            return cart;
        }
        throw new ResourceNotFoundException("cart not found with user id: "+userId);
    }

    public Cart setCart(Cart cart)
    {
        Cart newCart = null;
        if(cart!=null)
        {
            cart = cartRepository.save(cart);
        }
        return newCart;
    }

    public Cart getCartById(int id) throws ResourceNotFoundException
    {
        Cart cart = cartRepository.findById(id);
        if(cart != null)
        {
            return cart;
        }
        
        throw new ResourceNotFoundException("cart not found with id: "+id);
    }

    public CartItem getCartItemById(int id) throws ResourceNotFoundException
    {
        CartItem cartItem = cartItemRepository.findById(id);
        if(cartItem != null)
        {
            return cartItem;
        }
        
        throw new ResourceNotFoundException("cart not found with id: "+id);
    }

    public CartItem getCartItemByCartIdAndProductId(int cartId, int productId) throws ResourceNotFoundException
    {
        CartItem cartItem = cartItemRepository.findByCartCartIdAndProductProductId(cartId, productId);
        if(cartItem != null)
        {
            return cartItem;
        }
        
        throw new ResourceNotFoundException("cart not found with cart id: "+cartId+"and product id: "+productId);
    }

}
