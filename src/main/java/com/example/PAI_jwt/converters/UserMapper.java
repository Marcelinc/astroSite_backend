/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.PAI_jwt.converters;

import com.example.PAI_jwt.model.UserDao;
import com.example.PAI_jwt.model.UserDto;
import org.mapstruct.Mapper;

/**
 *
 * @author Marcelinc
 */
@Mapper
public interface UserMapper {
    UserDto mapStudentToStudentDto(UserDao student);
}
