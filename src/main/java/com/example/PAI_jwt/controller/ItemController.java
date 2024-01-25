/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.controller;

import com.example.PAI_jwt.model.ItemDao;
import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.service.ItemServiceImpl;
import com.example.PAI_jwt.service.UserServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelinc
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/items")
public class ItemController {
    
    private final ItemServiceImpl itemService;
    private final UserServiceImpl userService;

    @PostMapping({"/addItem"})
    public ResponseEntity<?> addItem(@RequestBody ItemDao item){
        JsonResponse response;
        ItemDao insertedItem = itemService.addItem(item);
        if(insertedItem != null)
            response = new JsonResponse<>("Success",insertedItem);
        else
            response = new JsonResponse<>("Dodawanie produktu nie powiodło się");
        return ResponseEntity.ok(response);
    }
    
    @GetMapping({"/getUserItems/{ownerId}"})
    public ResponseEntity<?> getUserItems(@PathVariable Long ownerId){
        return ResponseEntity.ok(new JsonResponse("Success",itemService.getUserItems(ownerId)));
        
    }
    
    @PutMapping({"/withdrawItem/{id}"})
    public ResponseEntity<?> changeItemStatus(@PathVariable long id, Authentication authentication){
        long userId = userService.getUserId(authentication.getName());
        int result = itemService.editItemStatus(id, userId);
        
        if(result > 0)
            return ResponseEntity.ok(new JsonResponse("Success"));
        else
            return ResponseEntity.ok(new JsonResponse("Błąd podczas wycofywania produkty"));
    }
    
    @GetMapping({"/getPopular"})
    public ResponseEntity<?> getPopular(){
        List<ItemDao> res = itemService.getPopularItems();
        if(res != null){
            return ResponseEntity.ok(new JsonResponse("Success",res));
        } else{
            return ResponseEntity.ok(new JsonResponse("Błąd podczas pobierania danych"));
        }
    }
    
    @GetMapping({"/getTelescopes"})
    public ResponseEntity<?> getTelescopes(){
        List<ItemDao> res = itemService.getTelescopes();
        if(res != null){
            return ResponseEntity.ok(new JsonResponse("Success",res));
        } else{
            return ResponseEntity.ok(new JsonResponse("Błąd podczas pobierania danych"));
        }
    }
    
    @GetMapping({"/getLens"})
    public ResponseEntity<?> getLens(){
        List<ItemDao> res = itemService.getLens();
        if(res != null){
            return ResponseEntity.ok(new JsonResponse("Success",res));
        } else{
            return ResponseEntity.ok(new JsonResponse("Błąd podczas pobierania danych"));
        }
    }
    
     @GetMapping({"/getFilters"})
    public ResponseEntity<?> getFilters(){
        List<ItemDao> res = itemService.getFilters();
        if(res != null){
            return ResponseEntity.ok(new JsonResponse("Success",res));
        } else{
            return ResponseEntity.ok(new JsonResponse("Błąd podczas pobierania danych"));
        }
    }
    
     @GetMapping({"/getBinoculars"})
    public ResponseEntity<?> getBinoculars(){
        List<ItemDao> res = itemService.getBinoculars();
        if(res != null){
            return ResponseEntity.ok(new JsonResponse("Success",res));
        } else{
            return ResponseEntity.ok(new JsonResponse("Błąd podczas pobierania danych"));
        }
    }
}
