package com.shoppingcart.rest.shoppingcartservice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ProductColor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int colorId;

    @NotEmpty(message = "Color name should not be empty")
    private String colorName;

    @ManyToOne
    @JsonBackReference(value = "productcolor-product")
    private Product product;

   
    public ProductColor(int colorId, String colorName, Product product) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.product = product;
    }

    public ProductColor() {
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
