package com.ruslan.lesson3_5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class PhoneBookContact {

    private static final String EMPTY_STRING = "";

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public Set<String> phones;

    public PhoneBookContact(@NotNull String firstName, @Nullable String lastName, @NotNull Collection<String> phones) {
        this.firstName = firstName;
        this.lastName = lastName == null ? EMPTY_STRING : lastName;
       // this.lastName = Objects.requireNonNullElse(lastName, "");
        this.phones = (Set<String>) phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookContact that = (PhoneBookContact) o;
        return firstName.equals(that.firstName) &&
            lastName.equals(that.lastName) &&
            phones.equals(that.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phones);
    }

}
