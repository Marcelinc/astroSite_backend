/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;


/**
 *
 * @author Marcelinc
 */
public interface UserService {
    public UserDao getUserByUsername(String username);
    
    //public UserDao getUser(String username);
}
