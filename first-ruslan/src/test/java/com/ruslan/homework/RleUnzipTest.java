package com.ruslan.homework;

import com.ruslan.GenerateStringUtils;
import com.ruslan.lesson2.homework.rle.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class RleUnzipTest {

    @Test
    public void Zip_not_works_with_null() {

        String nullable = null;
        String input = Rle.unzip(nullable);
        Assertions.assertEquals(null, input);

    }

    @Test
    public void Zip_returns_empty_when_input_is_empty(){

        String empty = "";
        Rle.unzip(empty);
        Assertions.assertEquals("",empty);

    }

    @Test
    public void Zip_must_works_correctly(){

        String expected = GenerateStringUtils.genStrRandomRepeatableChars(10,12,100);
        String zip = Rle.zip(expected);
        String result = Rle.unzip(zip);
        Assertions.assertEquals(expected, result);

    }

}
