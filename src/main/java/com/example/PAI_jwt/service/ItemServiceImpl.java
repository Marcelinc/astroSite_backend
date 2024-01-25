/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PAI_jwt.repository.ItemRepository;
import java.util.List;

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

    @Override
    public List<ItemDao> getUserItems(Long ownerId) {
        return itemRepository.getUserItems(ownerId);
    }

    @Override
    public int editItemStatus(long id_item, long id_owner) {
        return itemRepository.changeItemStatus(id_item, id_owner);
    }

    @Override
    public List<ItemDao> getPopularItems() {
        return itemRepository.getPopular();
    }

    @Override
    public List<ItemDao> getTelescopes() {
        return itemRepository.getTelescopes();
    }
    
    @Override
    public List<ItemDao> getLens() {
        return itemRepository.getLens();
    }
    
    @Override
    public List<ItemDao> getFilters() {
        return itemRepository.getFilters();
    }
    
    @Override
    public List<ItemDao> getBinoculars() {
        return itemRepository.getBinoculars();
    }

    @Override
    public int getSoldCount(long id_item) {
        return itemRepository.getSoldCount(id_item);
    }

    @Override
    public int setSoldCount(int count, long id_item) {
        return itemRepository.changeSoldCount(count, id_item);
    }
    
}
