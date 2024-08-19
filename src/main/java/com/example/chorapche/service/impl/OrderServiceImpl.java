package com.example.chorapche.service.impl;

import com.example.chorapche.model.dto.OrderInfoDTO;
import com.example.chorapche.model.entity.CartItem;
import com.example.chorapche.model.entity.Order;
import com.example.chorapche.repos.CartItemRepository;
import com.example.chorapche.repos.OrderRepository;
import com.example.chorapche.service.OrderService;
import com.example.chorapche.session.CurrentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CurrentOrder currentOrder;

    private final CartItemRepository cartItemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            CurrentOrder currentOrder, CartItemRepository cartItemRepository) {
        this.orderRepository = orderRepository;
        this.currentOrder = currentOrder;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void addOrder(OrderInfoDTO orderInfoDTO) {
        Order order = new Order();

        // Set order details
        order.setFirstSecondName(orderInfoDTO.getFirstName() + " " + orderInfoDTO.getSecondName());
        order.setAddress(orderInfoDTO.getAddress());
        order.setEmail(orderInfoDTO.getEmail());
        order.setPhoneNumber(orderInfoDTO.getPhoneNumber());

        // Ensure that cart items are associated with the order
        List<CartItem> cartItems = this.currentOrder.getCartItemList();
        order.setCartItems(cartItems);

        // Save the order, which will also save the associated cart items
        this.orderRepository.save(order);
    }

    private void saveCartItems(List<CartItem> cartItems) {
        this.cartItemRepository.saveAll(cartItems);
    }

}
