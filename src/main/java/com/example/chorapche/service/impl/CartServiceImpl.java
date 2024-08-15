package com.example.chorapche.service.impl;

import com.example.chorapche.model.dto.CartItemDTO;
import com.example.chorapche.model.entity.CartItem;
import com.example.chorapche.service.CartService;
import com.example.chorapche.service.ProductService;
import com.example.chorapche.session.CurrentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CurrentOrder currentOrder;
    private final ProductService productService;

    @Autowired
    public CartServiceImpl( CurrentOrder currentOrder,
                           ProductService productService) {
        this.currentOrder = currentOrder;
        this.productService=productService;
    }

    @Override
    public void addCartItem(CartItemDTO cartItemDTO) {

        CartItem cartItem = new CartItem();
        boolean flag = false;

       cartItem.setProduct(this.productService.getProductByName(cartItemDTO.getProductName()));
       cartItem.setQuantity(cartItemDTO.getQuantity());

        List<CartItem> cartItems = this.currentOrder.getCartItemList();
        for (CartItem item: cartItems) {
            if(item.getProduct().getName().equals(cartItemDTO.getProductName())){
                item.setQuantity(item.getQuantity()+cartItemDTO.getQuantity());
                this.currentOrder.setCartItemList(cartItems);
                flag=true;
            }
        }
        if(!flag){
            cartItems.add(cartItem);
            this.currentOrder.setCartItemList(cartItems);
        }
    }

    @Override
    public void deleteCartItem(String name) {
        List<CartItem> cartItemList = this.currentOrder.getCartItemList();

        Iterator<CartItem> iterator = cartItemList.iterator();

        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();

            if (cartItem.getProduct().getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

        @Override
        public double calculateTotalCost() {
            double totalCost = 0;

            if (this.currentOrder.getCartItemList().isEmpty()) {
                return 0.00;
            }

            for (CartItem item : this.currentOrder.getCartItemList()) {
                totalCost += item.getProduct().getPrice() * item.getQuantity();
            }
            return stringToDouble(String.format("%.2f", totalCost));
        }

    @Override
    public double calculateTotalCostPlusDelivery() {
        if(calculateTotalCost()>30){
            return calculateTotalCost();
        }
        return calculateTotalCost()+6;
    }
    public static double stringToDouble(String input){

        input = input.replace(',', '.');
        return Double.parseDouble(input);
    }
}
