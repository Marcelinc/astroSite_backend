/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @Column 
    private Double price;
    
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserDao user;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
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



    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }
}
