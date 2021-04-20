package com.prvz.lesson3_5;

import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        PhoneBookService phoneBookService = new InmemoryPhoneBookService();

        phoneBookService.addNewContact(
            new PhoneBookContact(
                "a",
                Arrays.asList("+79991112223"),
                "Comment"
            )
        );

        Collection<PhoneBookContact> all = phoneBookService.findAll();

        all.add(new PhoneBookContact(
            "a",
            Arrays.asList("+79991112223"),
            "Comment"
        ));

        all.clear();

    }

}
