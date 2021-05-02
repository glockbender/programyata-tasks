package com.prvz.lesson3_5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class InmemoryPhoneBookService implements PhoneBookService {

    private Collection<PhoneBookContact> contactsStorage = new ArrayList<>();

    @Override
    @Nullable
    // O(n) -> O(1) -> O(logN)
    public PhoneBookContact findByName(@NotNull String name) {

        for (PhoneBookContact contact : contactsStorage) {
            if (contact.name.equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    @Nullable
    // O(n^2) -> O(n*logn) -> O(1)
    public PhoneBookContact findByPhone(@NotNull String phone) {

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
