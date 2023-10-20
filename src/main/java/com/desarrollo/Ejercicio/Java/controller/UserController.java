package com.desarrollo.Ejercicio.Java.controller;

import com.desarrollo.Ejercicio.Java.repository.UserRequest;
import com.desarrollo.Ejercicio.Java.repository.UserResponse;
import com.desarrollo.Ejercicio.Java.repository.entity.User;
import com.desarrollo.Ejercicio.Java.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * createUser().
     * Metodo para agregar nuevos usuarios.
     *
     */
    @ApiOperation(value = "This method is used to add a user.",
                    notes = "add new user.")
    @PostMapping("/add")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) throws Exception {
        log.info("Calling /add");
        var response = userService.createUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * getAllUser().
     * Metodo que trae la lista completa de usuarios.
     *
     */
    @ApiOperation(value = "This method is used to get list all users.",
            notes = "Get a list with all the user.")
    @GetMapping("/listAll")
    public ResponseEntity<List<User>> getAllUser() {
        log.info("Calling /listAll");
        return ResponseEntity.ok(userService.getAllUser());
    }

}
