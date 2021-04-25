package com.nikita.lesson4;

import java.util.Collection;

public interface PhoneBookService {
    Contact findByName(String name);

    Contact findByPhone(String phone);

    Collection<Contact> findAll();

    void addNewContact(Contact contact);

    void updateContact(Contact contact);
}
