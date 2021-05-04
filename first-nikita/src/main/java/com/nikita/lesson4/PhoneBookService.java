package com.nikita.lesson4;

import java.util.Collection;

public interface PhoneBookService {
    Contact findByName(String name);

    Collection<PhoneBookContact> findByPhone(String phone);

    Collection<PhoneBookContact> findAll();

    void addNewContact(Contact contact);

    void updateContact(Contact contact);
}
