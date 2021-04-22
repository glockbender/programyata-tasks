package com.nikita.lesson4;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryPhoneBookService implements PhoneBookService {
    private Collection<Contact> contactsStorage = new ArrayList<>();

    @Override
    public Contact findByName(String name) {
        for (Contact contact : contactsStorage) {
            if (contact.name.equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findByPhone(String phone) {
        for (Contact contact : contactsStorage) {
            for (Contact innerPhone : contactsStorage) {
                if (innerPhone.equals(phone)) {
                    return contact;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<Contact> findAll() {
        return new ArrayList<>(contactsStorage);
    }

    @Override
    public void addNewContact(Contact contact) {
        contactsStorage.add(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        Contact found = findByName(contact.name);
        if (found == null) {
            throw new ContactNotFoundExeption();
        }
        found.comment = contact.comment;
        found.phones = contact.phones;
    }
}
