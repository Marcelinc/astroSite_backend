/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.OrderItemsDao;
import com.example.PAI_jwt.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelinc
 */
@Service
public class OrderItemsServiceImpl implements OrderItemsService{
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItemsDao addItemToOrder(Long id_item, Long id_order) {
        OrderItemsDao orderItem = new OrderItemsDao();
        orderItem.setId_order(id_order);
        orderItem.setId_orderItem(id_item);
        return orderItemsRepository.save(orderItem);
    }
    
}
