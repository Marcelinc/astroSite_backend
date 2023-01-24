/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;
import com.example.PAI_jwt.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelinc
 */
@Service
public class JwtUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userDao;
    
    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
        UserDao user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
    
    public UserDao save(UserDao user) {
        UserDao newUser = new UserDao();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setProfileImg("profile3");
        return userDao.save(newUser);
    }
}
