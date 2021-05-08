package com.ruslan.lesson3_5;

import java.util.ArrayList;
import java.util.Collection;

public class InmemoryPhoneBookService implements PhoneBookService {

    private Collection<PhoneBookContact> contactsStorage = new ArrayList<>();

    @Override
    public PhoneBookContact findByName(String name) {
        for (PhoneBookContact contact : contactsStorage) {
            if (contact.firstName.equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public PhoneBookContact findByPhone(String phone) {
        for (PhoneBookContact contact : contactsStorage) {
            for (String innerPhone : contact.phones) {
                if (innerPhone.equals(phone)) {
                    return contact;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<PhoneBookContact> findAll() {
        return new ArrayList<>(contactsStorage);
    }

    @Override
    public void addNewContact(PhoneBookContact phoneBookContact) {

        contactsStorage.add(phoneBookContact);

    }

    @Override
    public void updateContact(PhoneBookContact phoneBookContact) {
        PhoneBookContact found = findByName(phoneBookContact.firstName);
        if(found == null) {
            throw new ContactNotFoundException();
        }
        found.firstName = phoneBookContact.firstName;
        found.phones = phoneBookContact.phones;

    }
}
