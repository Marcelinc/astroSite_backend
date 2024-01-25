/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PAI_jwt.config;

import com.example.PAI_jwt.model.JsonResponse;
import com.example.PAI_jwt.service.JwtUserDetailsService;
import com.google.gson.Gson;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Marcelinc
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    //private Gson gson = new Gson();
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        
        // Token JWT ma postać "Bearer token". Należy usunąć słowo
        // Bearer i pobrać tylko właściwy token
        if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            
            //String res;
            ///PrintWriter out = response.getWriter();
            //response.setContentType("application/json");
            //response.setCharacterEncoding("UTF-8");
            
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
                //res = gson.toJson(new JsonResponse("Bad token"));
                //out.print(res);
                //out.flush();
                
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
                //res = gson.toJson(new JsonResponse("Bad token"));
                //out.print(res);
                //out.flush();
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }
        
        // Po uzyskaniu tokena należy go zweryfikować
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
        
            // Jeśli token jest poprawny, będzie konfigurowane
            // uwierzytelnianie w Spring Security
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Po powyższych ustawieniach, bieżący użytkownik jest
                // traktowany jako uwierzytelniony, Konfiguracja
                // Spring Security - zakończona powodzeniem
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
    
        chain.doFilter(request, response);
    }
}
