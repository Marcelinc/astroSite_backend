/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.OrderDao;
import java.util.List;

/**
 *
 * @author Marcelinc
 */
public interface OrderService {
   public OrderDao createOrder(OrderDao order);
   
   public List<OrderDao> getOrders(long buyer);
}
