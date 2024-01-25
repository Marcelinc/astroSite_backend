/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.service;

import com.example.PAI_jwt.model.ItemDao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcelinc
 */
public interface ItemService {
    public ItemDao addItem(ItemDao item);
    
    public List<ItemDao> getUserItems(Long ownerId);
    
    public int editItemStatus(long id_item,long id_owner);
    
    public List<ItemDao> getPopularItems();
    
    public List<ItemDao> getTelescopes();
    
    public List<ItemDao> getLens();
    
    public List<ItemDao> getFilters();
    
    public List<ItemDao> getBinoculars();
    
    public int getSoldCount(long id_item);
    
    public int setSoldCount(int count,long id_item);
}
