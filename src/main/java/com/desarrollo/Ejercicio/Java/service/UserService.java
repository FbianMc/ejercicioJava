package com.desarrollo.Ejercicio.Java.service;

import com.desarrollo.Ejercicio.Java.repository.UserRequest;
import com.desarrollo.Ejercicio.Java.repository.UserResponse;
import com.desarrollo.Ejercicio.Java.repository.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAllUser();
    UserResponse createUser(UserRequest user) throws Exception;

}
