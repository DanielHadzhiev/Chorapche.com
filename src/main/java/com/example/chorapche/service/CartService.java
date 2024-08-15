package com.example.chorapche.service;

import com.example.chorapche.model.dto.CartItemDTO;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    void addCartItem(CartItemDTO cartItemDTO);

    void deleteCartItem(String name);

    double calculateTotalCost();

    double calculateTotalCostPlusDelivery();
}
