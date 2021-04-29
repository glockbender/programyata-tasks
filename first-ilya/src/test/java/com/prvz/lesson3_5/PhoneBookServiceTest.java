package com.prvz.lesson3_5;

import com.prvz.TestStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PhoneBookServiceTest {

    @Test
    public void findByName_shouldReturn_foundContact() {

        PhoneBookService service = new InmemoryPhoneBookService();

        String name = "abc";

        Collection<String> phones = new HashSet<>();
        phones.add("123");
        phones.add("345");

        String comment = "aaa";

        PhoneBookContact expectedContact = new PhoneBookContact(name, phones, comment);

        service.addNewContact(new PhoneBookContact(name, phones, comment));

        PhoneBookContact found = service.findByName(name);

        Assertions.assertEquals(expectedContact, found);

    }

    @Test
    public void findByName_shouldNotFind_contact() {

        PhoneBookService service = new InmemoryPhoneBookService();

        String name = "abc";

        Collection<String> phones = new HashSet<>();
        phones.add("123");
        phones.add("345");

        String comment = "aaa";

        service.addNewContact(new PhoneBookContact("bcd", phones, comment));

        PhoneBookContact found = service.findByName(name);

        Assertions.assertNull(found);
    }

    @Test
    public void findAll_shouldReturn_allContacts() {

        PhoneBookService service = new InmemoryPhoneBookService();

        Collection<String> phones = new HashSet<>();
        phones.add("123");
        phones.add("345");

        String comment = "aaa";

        Collection<PhoneBookContact> expected = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String name = TestStringUtils.generateRandom(10);
            expected.add(new PhoneBookContact(name, phones, comment));
            service.addNewContact(new PhoneBookContact(name, phones, comment));
        }

        Collection<PhoneBookContact> found = service.findAll();

        Assertions.assertIterableEquals(expected, found);
    }

    @Test
    public void findAll_shouldReturn_emptyList() {

        PhoneBookService service = new InmemoryPhoneBookService();

        Assertions.assertTrue(service.findAll().isEmpty());

    }

}
