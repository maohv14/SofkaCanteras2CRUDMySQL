package com.cantera2sofka.contactlist.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Clase que permite la representación de la tabla en la base de datos con Spring boot
 * @author Mauro Villada, mauro1040@gmail.com
 * @version 1.0.0, 2022-03-13
 */

@Data
@Entity
@Table(name = "con_list")
public class ContactList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "born_at")
    private String bornAt;

    @Column(name = "delete_at")
    private String deleteAt;

}
