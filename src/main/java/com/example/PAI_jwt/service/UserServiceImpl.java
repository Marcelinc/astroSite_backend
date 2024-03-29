/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.service;


import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;
import com.example.PAI_jwt.repository.UserRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelinc
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    //private final UserMapper userMapper;

    @Override
    public UserDao getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    
    
    @Override
    public UserDto getUserData(String username){
        return userRepository.getUserData(username);
    }

    @Override
    public int editUser(String username, String email, String actualUsername) {
         return userRepository.editUser(username, email, actualUsername);
    }
    
    @Override
    public long getUserId(String username){
        return userRepository.getUserId(username);
    }
    
}
