/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Marcelinc
 */
@Entity
@Table(name = "zamowienie")
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_order;
    
    @Column
    private Long buyer; 
    
    @DateTimeFormat(pattern="dd-MM-yyyy")
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date order_date;
    
    @Column
    private Double cost;
    
    @Enumerated(EnumType.STRING)
    @Column
    private StatusType status;
    
    private enum StatusType {
        FULFILL,INPROGRESS,CANCELLED,
    }

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public Long getBuyer() {
        return buyer;
    }

    public void setBuyer(Long buyer) {
        this.buyer = buyer;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    
    
}
