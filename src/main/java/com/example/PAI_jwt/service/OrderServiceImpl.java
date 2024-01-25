/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PAI_jwt.repository.OrderRepository;
import com.example.PAI_jwt.repository.UserRepository;
import java.util.List;

/**
 *
 * @author Marcelinc
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDao createOrder(OrderDao order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrderDao> getOrders(long buyer) {
        return orderRepository.getOrders(buyer);
    }
    
}
