package com.desarrollo.Ejercicio.Java.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * User
 *
 */

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USERS")
public class User {

    /**
     * int id.
     * Identificador de usuario.
     *
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    /**
     * String description.
     * Nombre de usuario.
     *
     */
    @Column(name = "NAME", nullable = false)
    @Schema(description = "User name.", example = "Name LastName")
    private String name;

    /**
     * String description.
     * Contraseña del usuario.
     *
     */
    @Column(name = "PASSWORD", nullable = false)
    @Schema(description = "User password.", example = "abcdefg1")
    private String password;

    /**
     * String description.
     * Correo de usuario.
     *
     */
    @Column(unique = true, name = "EMAIL", nullable = false)
    @Schema(description = "User email.", example = "name@email.com")
    private String email;

    /**
     * Set<Phone> phones.
     * Set list phone del usuario.
     *
     */
    @Schema(description = "Phones email.", example = "list phone[]")
    @OneToMany(cascade= CascadeType.PERSIST, mappedBy = "user")
    private List<Phone> phones;

    /**
     * Date created.
     * Fecha de creacion del usuario.
     *
     */
    @Column(name = "CREATED")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Creation date user.", example = "2023-01-01 01:00:00")
    private Date created;

    /**
     * Date modified.
     * Fecha de modificacion del usuario.
     *
     */
    @Column(name = "MODIFIED")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Modified date user.", example = "2023-01-01 01:00:00")
    private Date modified;

    /**
     * Date last login.
     * Fecha de ultima conexion del usuario.
     *
     */
    @Column(name = "LAST_LOGIN")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Modified date user.", example = "2023-01-01 01:00:00")
    private Date last_login;

    /**
     * boolean  .
     * Is active user or not.
     *
     */
    @Column(name = "IS_ACTIVE")
    @Schema(description = "User isactive.", example = "TRUE")
    private boolean isactive;
    public void addPhones(Phone phone){
        phones.add(phone);
        phone.setUser(this);
    }
}
