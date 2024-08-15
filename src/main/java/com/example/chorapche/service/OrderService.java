package com.example.chorapche.service;


import com.example.chorapche.model.dto.OrderInfoDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    void addOrder(OrderInfoDTO orderInfoDTO);

}
