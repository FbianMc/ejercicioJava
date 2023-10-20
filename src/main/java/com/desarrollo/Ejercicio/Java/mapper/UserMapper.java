package com.desarrollo.Ejercicio.Java.mapper;

import com.desarrollo.Ejercicio.Java.repository.UserRequest;
import com.desarrollo.Ejercicio.Java.repository.UserResponse;
import com.desarrollo.Ejercicio.Java.repository.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertUserRequestToUser(UserRequest userRequest){

        return this.modelMapper.map(userRequest, User.class);
    }
    public UserResponse convertUserToUserResponse(User user){

        return this.modelMapper.map(user, UserResponse.class);
    }
}
