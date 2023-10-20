package com.desarrollo.Ejercicio.Java.repository;

import com.desarrollo.Ejercicio.Java.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAll();
    List<User> findByEmail(String email);
}
