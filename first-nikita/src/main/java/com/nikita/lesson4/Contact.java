package com.nikita.lesson4;

import java.util.Collection;

public class Contact {
     String name;
     Collection<String> phones;
     String comment;

    public Contact(String name, Collection<String> phones, String comment) {
        this.name = name;
        this.phones = phones;
        this.comment = comment;
    }
}
