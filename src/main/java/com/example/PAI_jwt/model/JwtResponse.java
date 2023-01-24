/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.model;

import java.io.Serializable;

/**
 *
 * @author Marcelinc
 */
public class JwtResponse implements Serializable{
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    public String getToken() {
        return this.jwttoken;
    }
}
