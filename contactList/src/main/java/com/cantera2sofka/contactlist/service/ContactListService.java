package com.cantera2sofka.contactlist.service;

import com.cantera2sofka.contactlist.dao.ContactDao;
import com.cantera2sofka.contactlist.domain.ContactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ContactListService implements IContacService {

    @Autowired
    private ContactDao contactDao;

    @Override
    @Transactional(readOnly = true)
    public List<ContactList> listar() {
        return (List<ContactList>) contactDao.findAll();
    }

    @Override
    @Transactional
    public ContactList save(ContactList contactList) {
        return contactDao.save(contactList);
    }

    @Override
    @Transactional
    public ContactList update(Long id, ContactList contactList) {
        contactList.setId(id);
        return contactDao.save(contactList);
    }

    @Transactional
    public void updateName(Long id, ContactList contactList){
        contactDao.updateName(id, contactList.getName());
    }

    @Transactional
    public void updatePhoneNumber(Long id, ContactList contactList){
        contactDao.updatePhoneNumber(id, contactList.getPhoneNumber());
    }

    @Transactional
    public void updateEmail(Long id, ContactList contactList){
        contactDao.updateEmail(id, contactList.getEmail());
    }

    @Transactional
    public void updateBornAt(Long id, ContactList contactList){
        contactDao.updateBornAt(id, contactList.getBornAt());
    }

    @Transactional
    public void updateDeleteAt(Long id, ContactList contactList){
        contactDao.updateDeleteAt(id, contactList.getDeleteAt());
    }

    @Override
    @Transactional
    public void delete(ContactList contactList) {
        contactDao.delete(contactList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContactList> findContact(ContactList contactList) {
        return contactDao.findById(contactList.getId());
    }
}
