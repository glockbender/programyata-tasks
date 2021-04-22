package com.ruslan.lesson3_5;

import java.util.Collection;

public class PhoneBookContact {

    String name;

    Collection<String> phones;

    String comment;

    public PhoneBookContact(String name, Collection<String> phones, String comment) {
        this.name = name;
        this.phones = phones;
        this.comment = comment;
    }

}
