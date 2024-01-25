/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.repository;

import com.example.PAI_jwt.model.OrderDao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcelinc
 */
@Repository
public interface OrderRepository extends CrudRepository<OrderDao,Integer>{
    @Query("select o from OrderDao o where o.buyer = ?1")
    public List<OrderDao> getOrders(Long buyer);
}
