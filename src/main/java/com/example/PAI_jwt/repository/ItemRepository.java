/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.repository;

import com.example.PAI_jwt.model.ItemDao;
import com.example.PAI_jwt.model.OrderDao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcelinc
 */
@Repository
public interface ItemRepository extends CrudRepository<ItemDao,Integer>{
    
    @Query("select i from ItemDao i where i.owner = ?1 order by available")
    public List<ItemDao> getUserItems(Long idOwner);
    
    @Transactional
    @Modifying
    @Query("update ItemDao i set i.available = false where i.id_item = ?1 and i.owner = ?2")
    public int changeItemStatus(long id_item,long id_owner);
    
    @Transactional
    @Modifying
    @Query("update ItemDao i set i.soldCount = ?1 where i.id_item = ?2")
    public int changeSoldCount(int count,long id_item);
    
    @Query("select i.soldCount from ItemDao i where i.id_item = ?1")
    public int getSoldCount(long id_item);
    
    @Query(value="select * from Item order by sold_count desc limit 5",nativeQuery=true)
    public List<ItemDao> getPopular();
    
    @Query("select i from ItemDao i where i.type = 'TELESCOPE'")
    public List<ItemDao> getTelescopes();
    
    @Query("select i from ItemDao i where i.type = 'LENS'")
    public List<ItemDao> getLens();
    
    @Query("select i from ItemDao i where i.type = 'FILTER'")
    public List<ItemDao> getFilters();
    
    @Query("select i from ItemDao i where i.type = 'BINOCULARS'")
    public List<ItemDao> getBinoculars();
}
