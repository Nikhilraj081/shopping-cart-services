package com.shoppingcart.rest.shoppingcartservice.Exceptions;

import org.hibernate.annotations.NotFound;

public class ResourceNotFoundException extends Exception {

   
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

}
