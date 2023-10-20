package com.desarrollo.Ejercicio.Java.service;

import com.desarrollo.Ejercicio.Java.controller.UserController;
import com.desarrollo.Ejercicio.Java.mapper.UserMapper;
import com.desarrollo.Ejercicio.Java.repository.UserRepository;
import com.desarrollo.Ejercicio.Java.repository.UserRequest;
import com.desarrollo.Ejercicio.Java.repository.UserResponse;
import com.desarrollo.Ejercicio.Java.repository.entity.Phone;
import com.desarrollo.Ejercicio.Java.repository.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest) throws Exception {
        var user = userRepository.findByEmail(userRequest.getEmail());
        var userResponse = new UserResponse();

        try{
            if(user.isEmpty()) {
                validMail(userRequest.getEmail());
                validPass(userRequest.getPassword());

                User users = userMapper.convertUserRequestToUser(userRequest);
                users.setIsactive(true);
                users.setLast_login(new Date());
                users.getPhones().stream().toList().forEach(phone -> users.addPhones(phone));
                userRepository.save(users);
                log.info("Usuario creado {}", userRequest);

                userResponse = userMapper.convertUserToUserResponse(users);
            }else{
                log.info("El correo {} ya esta registrado.", userRequest.getEmail());
                throw new SecurityException("El correo "+userRequest.getEmail()+" ya esta registrado.");
            }
            return userResponse;
        }catch(Exception e){
            log.error("Exception", e);
            throw e;
        }
    }

    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();

        try{
            listUser.addAll(userRepository.findAll());
            log.info("Total rows {}",listUser.size());
            return listUser;
        }catch(Exception e){
            log.error("Exception", e);
            throw e;
        }
    }
    public void validMail(String mail) throws Exception {
        log.info("Call validMail");

        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);

        if (!matcher.matches()) {
            throw new SecurityException("El correo "+mail+" no tiene formato valido.");
        }
    }
    public void validPass(String pass) throws Exception {
        log.info("Call validPass");

        String regex = "^(?=\\w*\\d)(?=\\w*[a-z])\\S{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);

        if (!matcher.matches()) {
            throw new SecurityException("La contraseña debe contener minimo 8 caracter y al menos un numero.");
        }
    }

}
