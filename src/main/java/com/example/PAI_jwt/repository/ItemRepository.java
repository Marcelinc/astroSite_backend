/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.repository;

import com.example.PAI_jwt.model.ItemDao;
import com.example.PAI_jwt.model.OrderDao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marcelinc
 */
public interface ItemRepository extends CrudRepository<ItemDao,Integer>{
    
}
