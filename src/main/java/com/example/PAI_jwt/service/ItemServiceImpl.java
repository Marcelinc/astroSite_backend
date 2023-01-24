/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PAI_jwt.repository.ItemRepository;

/**
 *
 * @author Marcelinc
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDao addItem(ItemDao item) {
        return itemRepository.save(item);
    }
    
}
