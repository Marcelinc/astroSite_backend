/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.controller;

import com.example.PAI_jwt.model.ItemDao;
import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.model.OrderDao;
import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value="/items")
public class ItemController {
    
    private final ItemServiceImpl itemService;

    @PostMapping({"/addItem"})
    public ItemDao addItem(@RequestBody ItemDao item){
        //UserDao user = userService.getUserByUsername(username);
        //UserDao user = userService.getUserByUsername("lama") ;
        UserDao user = new UserDao();
        user.setEmail("xdd");
        user.setPassword("xdd");
        user.setUsername("xds");
        user.setId(123L);
        item.setUser(user);
//if(user != null)
            //return ResponseEntity.ok(new JsonResponse<>("Success",userService.getUserByUsername(username)));
            return itemService.addItem(item);
        //else
          //  return ResponseEntity.status(500).body(new JsonResponse("Błąd pobierania danych"));
    }
    
}
