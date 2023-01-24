/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.model;

import java.io.Serializable;

/**
 *
 * @author Marcelinc
 * @param <T>
 */
public class JsonResponse<T> implements Serializable{
    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonResponse(String message) {
        this.message = message;
    }
    
    public JsonResponse(String message, T data){
        this.message = message;
        this.data = data;
    }
    
    
}
