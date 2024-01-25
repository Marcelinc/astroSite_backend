/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.controller;

import com.example.PAI_jwt.config.JwtTokenUtil;
import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.model.JwtResponse;
import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;
import com.example.PAI_jwt.service.JwtUserDetailsService;
import com.example.PAI_jwt.service.UserServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping(value="/users")
public class UserController {
    private final UserServiceImpl userService;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    

    @GetMapping({"/getUser"})
    public ResponseEntity<?> getUser(Authentication authentication){
        UserDto user = userService.getUserData(authentication.getName());
        //UserDao user = userService.getUser(username);
        if(user != null)
            return ResponseEntity.ok(user);//ResponseEntity.status(200).body(new JsonResponse("Success",user));
        else
            return ResponseEntity.status(500).body(new JsonResponse("Błąd pobierania danych"));  
    }
    
    @PutMapping({"/edit"})
    public ResponseEntity<?> editUser(@RequestBody ObjectNode data, Authentication authentication){
        String username = data.get("username").asText();
        String email = data.get("email").asText();
        JsonResponse response;
        String token;
        if( username == null || email == null){
            return ResponseEntity.ok(new JsonResponse("Niepoprawne dane"));
        }
        int result = userService.editUser(username, email, authentication.getName());
        if(result > 0){
            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(userDetails != null){
                token = jwtTokenUtil.generateToken(userDetails);
            } else
                token = null;
            response = new JsonResponse<>("Success",token);
        } else{
            response = new JsonResponse("Aktualizowanie danych nie powiodło się");
        }
        return ResponseEntity.ok(response);
    }
}
