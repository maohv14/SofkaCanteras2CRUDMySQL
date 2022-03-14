package com.cantera2sofka.contactlist.controller;

import com.cantera2sofka.contactlist.domain.ContactList;
import com.cantera2sofka.contactlist.service.ContactListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase controlador con spring boot que permite establecer los puntos de acceso para el consumo de la API
 * @author Mauro Villada Villada, mauro1040@gmail.com
 * @version 1.0.0, 2022-03-13
 */

@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactListService contactListService;

    /**
     * Metodo para listar contactos
     * @return
     */
    @GetMapping(path ="/contacts")
    public List<ContactList> list(){
        var contacts = contactListService.listar();
        return contacts;
    }

    /**
     * Metodo para agregar contacto a la lista
     * @param contactList
     * @return
     */
    @PostMapping(path ="/contact")
    public ResponseEntity<ContactList> create(ContactList contactList){
        log.info("Contacto a crear: {}",contactList);
        contactListService.save(contactList);
        return new ResponseEntity<>(contactList, HttpStatus.CREATED);
    }

    /**
     * Metodo para eliminar contacto de la lista
     * @param contactList
     * @return
     */
    @DeleteMapping (path ="/contact/{id}")
    public ResponseEntity<ContactList> delete(ContactList contactList){
        log.info("Contacto a eliminar: {}",contactList);
        contactListService.delete(contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);

    }

    /**
     * Metodo para actualizar todos los elementos de la lista
     * @param contactList
     * @param id
     * @return
     */
    @PutMapping (path ="/contact/{id}")
    public ResponseEntity<ContactList> updateAll(ContactList contactList,@PathVariable("id")Long id){
        log.info("Contacto a modificar: {}",contactList);
        contactListService.update(id, contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar unicamente el nombre de un contacto en al lista
     * @param contactList
     * @param id
     * @return
     */
    @PatchMapping (path ="/contact/name/{id}")
    public ResponseEntity<ContactList> updateName(ContactList contactList,@PathVariable("id")Long id){
        contactListService.updateName(id, contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);

    }

    /**
     * Metodo para actualizar unicamente el telefono de un contacto en la lista
     * @param contactList
     * @param id
     * @return
     */
    @PatchMapping (path ="/contact/phoneNumber/{id}")
    public ResponseEntity<ContactList> updatePhoneNumber(ContactList contactList,@PathVariable("id")Long id){
        contactListService.updatePhoneNumber(id, contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar el email de un contacto en la lista
     * @param contactList
     * @param id
     * @return
     */
    @PatchMapping (path ="/contact/email/{id}")
    public ResponseEntity<ContactList> updateEmail(ContactList contactList,@PathVariable("id")Long id){
        contactListService.updateEmail(id, contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar fecha de nacimiento de un contacto en la lista
     * @param contactList
     * @param id
     * @return
     */
    @PatchMapping (path ="/contact/bornAt/{id}")
    public ResponseEntity<ContactList> updateBornAt(ContactList contactList,@PathVariable("id")Long id){
        contactListService.updateBornAt(id, contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    /**
     * Metodo para realizar borrado logíco de un contacto en la lista
     * @param contactList
     * @param id
     * @return
     */
    @PatchMapping (path ="/contact/deleteAt/{id}")
    public ResponseEntity<ContactList> logicDelete(ContactList contactList,@PathVariable("id")Long id){
        contactListService.updateDeleteAt(id, contactList);
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

}
