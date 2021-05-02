package com.prvz.lesson3_5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Set;

public class PhoneBookContact {

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public Set<String> phones;

    public PhoneBookContact(
        @NotNull String firstName,
        @Nullable String lastName,
        @NotNull Set<String> phones
    ) {
        this.firstName = firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookContact that = (PhoneBookContact) o;
        return firstName.equals(that.firstName) && Objects.equals(lastName, that.lastName) && phones.equals(that.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phones);
    }

    //
}
