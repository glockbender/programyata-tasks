package com.prvz.lesson3_5;

import java.util.ArrayList;
import java.util.Collection;

public class InmemoryPhoneBookService implements PhoneBookService {

    private Collection<PhoneBookContact> contactsStorage = new ArrayList<>();

    @Override
    public PhoneBookContact findByName(String name) {

        for (PhoneBookContact contact : contactsStorage) {
            if (contact.name.equals(name)) {
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
    public void addNewContact(PhoneBookContact contact) {
        contactsStorage.add(contact);
    }

    @Override
    public void updateContact(PhoneBookContact contact) {
        PhoneBookContact found = findByName(contact.name);
        if (found == null) {
            throw new ContactNotFoundException();
        }
        found.phones = contact.phones;
        found.comment = contact.comment;
    }
}
