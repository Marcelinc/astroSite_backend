/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.OrderItemsDao;

/**
 *
 * @author Marcelinc
 */
public interface OrderItemsService {
    public OrderItemsDao addItemToOrder(Long id_item,Long id_order);
}
