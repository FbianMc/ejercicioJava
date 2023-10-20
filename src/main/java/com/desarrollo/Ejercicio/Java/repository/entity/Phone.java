package com.desarrollo.Ejercicio.Java.repository.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;


import javax.persistence.*;


/**
 * Phone
 *
 */

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PHONES")
public class Phone {

    /**
     * int id.
     * Identificador del Telefono usuario.
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "User phone identificator.", example = "1")
    private Long id;

    /**
     * User user.
     * Usuario del telefono.
     *
     */
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    /**
     * Long phoneNumber.
     * Numero telefonico.
     *
     */
    @Column(name = "PHONE_NUMBER", nullable = false)
    @Schema(description = "Number phone.", example = "91963854")
    private String number;

    /**
     * Integer cityCode.
     * Codigo ciudad del telefono.
     *
     */
    @Column(name = "CITY_CODE", nullable = false)
    @Schema(description = "City code.", example = "9")
    private String citycode;

    /**
     * Integer countryCode.
     * Codigo pais del telefono.
     *
     */
    @Column(name = "COUNTRY_CODE", nullable = false)
    @Schema(description = "Country code.", example = "00")
    private String countrycode;
}
