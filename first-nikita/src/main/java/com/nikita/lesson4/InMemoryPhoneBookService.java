package com.nikita.lesson4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryPhoneBookService implements PhoneBookService {
    private Map<String, PhoneBookContact> nameAndContact = new HashMap<>();

    @Override
    public PhoneBookContact findByFullName(String firstName, String lastName) {
        String fullName = firstName + lastName;
        return nameAndContact.get(fullName);
    }


    @Override
    public Contact findByName(String name) {
        return null;
    }

    public Collection<PhoneBookContact> findByPhone (@NotNull String phone) {
        Collection<PhoneBookContact>result=new ArrayList<>();
        for (PhoneBookContact contact : nameAndContact.values()) {
                if (contact.getPhone().contains(phone){
                result.add(contact);
                }
            }
        return result;
    }

    @Override
    public Collection<PhoneBookContact> findAll() {
        return nameAndContact.values();
    }

    @Override
    public void addNewContact(Contact contact) {
        nameAndContact.add(contact);
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
