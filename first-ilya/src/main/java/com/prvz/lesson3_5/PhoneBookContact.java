package com.prvz.lesson3_5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PhoneBookContact {

    public static final String DEFAULT_LAST_NAME = "";

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    @NotNull
    private final Set<String> phones;

    public PhoneBookContact(
        @NotNull String firstName,
        @Nullable String lastName,
        @NotNull Set<String> phones
    ) {
        this.firstName = firstName;
        this.lastName = lastName == null ? DEFAULT_LAST_NAME : lastName;
        this.phones = new HashSet<>(phones);
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    @NotNull
    public Set<String> getPhones() {
        return new HashSet<>(phones);
    }

    public void addPhones(@NotNull Collection<String> phones) {
        this.phones.addAll(phones);
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

    @Override
    public String toString() {
        return "PhoneBookContact{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", phones=" + phones +
            '}';
    }

    //
}
