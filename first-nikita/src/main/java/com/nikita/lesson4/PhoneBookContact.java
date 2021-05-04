package com.nikita.lesson4;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PhoneBookContact {

    private static final String DEFAULT_LAST_NAME = "";
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final Set<String> phone;

    public PhoneBookContact(@NotNull String firstName, @Nullable String lastName, @NotNull Set<String> phone) {
        this.firstName = firstName;
        this.lastName = lastName == null ? DEFAULT_LAST_NAME : lastName;
        this.phone = phone;
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
    public Set<String> getPhone() {
        return new HashSet<>(phone);
    }

    @NotNull
    public void addPhones(Collection<String> phone) {
        this.phone.addAll(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookContact that = (PhoneBookContact) o;
        return firstName.equals(that.firstName) &&
            lastName.equals(that.lastName) &&
            phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phone);
    }

    @Override
    public String toString() {
        return "PhoneBookContact{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", phone=" + phone +
            '}';
    }
}

