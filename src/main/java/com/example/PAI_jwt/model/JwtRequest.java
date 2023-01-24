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
public class JwtRequest implements Serializable{
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
    
    // domyślny konstruktor dla parsowania JSON
    public JwtRequest() {
    }
    
    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
