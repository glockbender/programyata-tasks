package com.prvz.lesson3_5;

import java.util.Collection;
import java.util.Objects;

public class PhoneBookContact {

    public String name;

    public Collection<String> phones;

    public String comment;

    public PhoneBookContact(String name, Collection<String> phones, String comment) {
        this.name = name;
        this.phones = phones;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookContact that = (PhoneBookContact) o;
        return name.equals(that.name) && phones.equals(that.phones) && comment.equals(that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phones, comment);
    }

    //
}
