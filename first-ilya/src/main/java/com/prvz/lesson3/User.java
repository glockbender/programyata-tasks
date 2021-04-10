package com.prvz.lesson3;

public class User {

    public static byte MINIMUM_AGE = 18;

    private String firstname;

    private String lastname;

    private byte age;

    public User() {}

    public User(String firstname, String lastname, byte age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public byte getAge() {
        return age;
    }
}
