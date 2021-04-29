package com.ruslan.homework;

import com.ruslan.GenerateStringUtils;
import com.ruslan.lesson2.homework.rle.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RleZipTest {

    @Test
    public void Zip_not_works_with_null() {

        String nullable = null;
        String input = Rle.zip(nullable);
        Assertions.assertEquals(null, nullable);

    }

    @Test
    public void Zip_returns_empty_when_input_is_empty(){

        String empty = "";
        Rle.zip(empty);
        Assertions.assertEquals("",empty);

    }

    @Test
    public void Zip_must_works_correctly(){

        String input = GenerateStringUtils.genStrRandomRepeatableChars(3,5,40);
        String zip = Rle.zip(input);
        String expected = Rle.unzip(zip);
        Assertions.assertEquals(expected, input);

    }

}
