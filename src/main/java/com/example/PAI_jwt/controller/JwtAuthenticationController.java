/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.controller;

import com.example.PAI_jwt.config.JwtTokenUtil;
import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.model.JwtRequest;
import com.example.PAI_jwt.model.JwtResponse;
import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.repository.UserRepository;
import com.example.PAI_jwt.service.JwtUserDetailsService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelinc
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired 
    private UserRepository userRepository;
    
@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        
        if(userDetails != null){
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.ok(new JsonResponse("Brak użytkownika o podanym loginie i haśle"));
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDao user)
    throws Exception {
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty())
            return ResponseEntity.status(400).body(new JsonResponse("Błędne dane"));
        
        if(userRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.status(400).body(new JsonResponse("Użytkownik już istnieje"));
        }
        
        return ResponseEntity.ok(new JsonResponse<>("Success",userDetailsService.save(user).getUsername()));
    }
    
    @GetMapping({"/isLogged"})
    public ResponseEntity<?> isLogged(Authentication authentication){
        String username = authentication.getName();
        return ResponseEntity.ok(new JsonResponse("Success"));
    }
    
    private void authenticate(String username, String password)
    throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
