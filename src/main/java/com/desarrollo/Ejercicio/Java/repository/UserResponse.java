package com.desarrollo.Ejercicio.Java.repository;

import com.desarrollo.Ejercicio.Java.repository.PhoneRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class UserResponse implements Serializable {

    private static final long serialVersionUID = -5973049986010976600L;

    private String id;
    private String name;
    private String email;
    private String password;
    private List<PhoneRequest> phones;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private boolean isActive;

}