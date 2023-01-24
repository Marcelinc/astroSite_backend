/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.repository;

import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcelinc
 */
@Repository
public interface UserRepository extends JpaRepository<UserDao,Integer>{
    UserDao findByUsername(String username);
    
    //@Query("SELECT UserDto(u.id,u.username,u.email,u.profileImg) FROM UserDao u WHERE u.username = 'user'")
    //UserDao findUser(String username);
}
