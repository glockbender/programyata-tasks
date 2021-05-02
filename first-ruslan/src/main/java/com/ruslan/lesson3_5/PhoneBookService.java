package com.ruslan.lesson3_5;

import java.util.Collection;

public interface PhoneBookService {

    PhoneBookContact findByName(String name);

    PhoneBookContact findByPhone(String phone);

    Collection<PhoneBookContact> findAll();

    void addNewContact(PhoneBookContact phoneBookContact);

    void updateContact(PhoneBookContact phoneBookContact);

}
