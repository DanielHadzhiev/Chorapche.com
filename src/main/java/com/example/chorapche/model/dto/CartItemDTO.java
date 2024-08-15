package com.example.chorapche.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class CartItemDTO {

   @NotBlank(message = "This field is mandatory.")
    private String productName;

    @Positive(message = "Quantity must be greater than 0")
    @Min(value = 1, message = "The number must be a non-negative integer")
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
