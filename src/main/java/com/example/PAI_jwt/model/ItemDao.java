/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Marcelinc
 */
@Entity
@Table(name = "item")
public class ItemDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_item;
    
    @Column
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column
    private ItemType type;
    
    @Column 
    private Double price;
    
    @Column(columnDefinition = "integer default 0")
    private int soldCount;
    
    @Column(columnDefinition = "boolean default true")
    private boolean available = true;
    
    @Column
    private Long owner;

    private enum ItemType {
        TELESCOPE,LENS,FILTER,BINOCULARS
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getId_item() {
        return id_item;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    
}
