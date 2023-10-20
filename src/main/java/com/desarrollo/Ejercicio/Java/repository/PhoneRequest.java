package com.desarrollo.Ejercicio.Java.repository;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PhoneRequest implements Serializable {

    private static final long serialVersionUID = -1979361278989911857L;

    private String number;
    private String citycode;
    private String countrycode;

}