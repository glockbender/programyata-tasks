package com.prvz.lesson3_5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InmemoryPhoneBookService implements PhoneBookService {

    private final Map<String, PhoneBookContact> nameToContactMap = new HashMap<>();

    @Override
    @Nullable
    // O(n) -> O(1) -> O(logN)
    public PhoneBookContact findByFullName(@NotNull String firstName, @Nullable String lastName) {
        String fullName = firstName + (lastName == null ? "" : lastName);
        return nameToContactMap.get(fullName);
    }

    @Override
    @NotNull
    // O(n)
    public Collection<PhoneBookContact> findByPhone(@NotNull String phone) {

        Collection<PhoneBookContact> result = new ArrayList<>();

        for (PhoneBookContact contact : nameToContactMap.values()) {

            if (contact.getPhones().contains(phone)) {
                result.add(contact);
            }
        }

        return result;
    }

    @Override
    public Collection<PhoneBookContact> findAll() {
        return nameToContactMap.values();
    }

    @Override
    public void addNewContact(PhoneBookContact contact) {
        // 1: (fname = "aa", lname = "bb", phones = ["1","2"])
        // 2: (fname = "aa", lname = "bb", phones = ["3","4"])
        PhoneBookContact found = findByFullName(contact.getFirstName(), contact.getLastName());
        if (found == null) {
            nameToContactMap.put(contact.getFirstName() + contact.getLastName(), contact);
        } else {
            found.getPhones().addAll(contact.getPhones());
        }

    }

    @Override
    public void updateContact(PhoneBookContact contact) {
//        PhoneBookContact found = findByName(contact.name);
//        if (found == null) {
//            throw new ContactNotFoundException();
//        }
//        found.phones = contact.phones;
//        found.comment = contact.comment;
    }
}
