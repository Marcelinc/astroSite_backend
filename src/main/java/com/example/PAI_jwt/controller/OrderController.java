/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.controller;

import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.model.OrderDao;
import com.example.PAI_jwt.model.OrderItemDto;
import com.example.PAI_jwt.service.ItemServiceImpl;
import com.example.PAI_jwt.service.OrderItemsServiceImpl;
import com.example.PAI_jwt.service.OrderServiceImpl;
import com.example.PAI_jwt.service.UserServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelinc
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/orders")
public class OrderController {
    private final OrderServiceImpl orderService;
    private final ItemServiceImpl itemService;
    private final UserServiceImpl userService;
    private final OrderItemsServiceImpl orderItemsService;
    
    @PostMapping({"/create"})
    public ResponseEntity<?> createOrder(@RequestBody OrderItemDto orderItem){
        OrderDao orderDao = orderService.createOrder(orderItem.getOrder());
        System.out.println(orderItem.getId_item());
        if(orderDao != null){
            //add items to order
            for(Long id : orderItem.getId_item()){
                System.out.println(id);
                orderItemsService.addItemToOrder(id, orderDao.getId_order());
                
                //increase soldCount
                int count = itemService.getSoldCount(id);
                itemService.setSoldCount(count, id);
            }
            return ResponseEntity.ok(new JsonResponse("Success"));
        }
            
        return ResponseEntity.ok(new JsonResponse("Składanie zamówienia nie powiodło się"));
    }
    
    @GetMapping({"/getOrders"})
    public ResponseEntity<?> getOrders(Authentication authentication){
        long id_buyer = userService.getUserId(authentication.getName());
        //System.out.println(id_buyer);
        List<OrderDao> res = orderService.getOrders(id_buyer);
        if(res != null)
            return ResponseEntity.ok(new JsonResponse("Success",res));
        return ResponseEntity.ok(new JsonResponse("Błąd pobierania zamówień"));
    }
    
}
