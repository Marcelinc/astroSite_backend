/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.repository;

import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcelinc
 */
@Repository
public interface UserRepository extends JpaRepository<UserDao,Integer>{
    
    UserDao findByUsername(String username);
    
    @Query(value = "select new com.example.PAI_jwt.model.UserDto(u.id,u.username,u.email,u.profileImg) from UserDao u where u.username = ?1")
    UserDto getUserData(String username);
    
    @Transactional
    @Modifying
    @Query("update UserDao u set u.username = ?1, u.email = ?2 WHERE u.username = ?3")
    int editUser(String username,String email,String actualUsername);
    
    @Query("select u.id from UserDao u where u.username = ?1")
    long getUserId(String username);
    
}
