/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.controller;

import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelinc
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/users")
public class UserController {
    private final UserServiceImpl userService;
    

    @GetMapping({"/getUser/{username}"})
    public ResponseEntity<?> getUser(@PathVariable String username){
        UserDao user = userService.getUserByUsername(username);
        //UserDao user = userService.getUser(username);
        if(user != null)
            return ResponseEntity.ok(user);//ResponseEntity.status(200).body(new JsonResponse("Success",user));
        else
            return ResponseEntity.status(500).body(new JsonResponse("Błąd pobierania danych"));
        
       
    }
}
