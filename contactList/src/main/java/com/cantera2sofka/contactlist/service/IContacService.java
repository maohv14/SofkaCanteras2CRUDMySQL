package com.cantera2sofka.contactlist.service;

import com.cantera2sofka.contactlist.domain.ContactList;

import java.util.List;
import java.util.Optional;

public interface IContacService {

    public List<ContactList> listar();

    public ContactList save(ContactList contactList);

    public ContactList update(Long id, ContactList contactList);

    public void delete(ContactList contactList);

    public Optional<ContactList> findContact(ContactList contactList);
}
