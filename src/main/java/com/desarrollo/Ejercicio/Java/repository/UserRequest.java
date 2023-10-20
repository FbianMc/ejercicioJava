package com.desarrollo.Ejercicio.Java.repository;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserRequest implements Serializable {

    private static final long serialVersionUID = -3420598289900817942L;
    private String name;
    private String email;
    private String password;
    private List<PhoneRequest> phones;

}