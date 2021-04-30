package com.ruslan.homework;

import com.ruslan.GenerateStringUtils;
import com.ruslan.lesson2.homework.rle.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RleTest {

    @Test
    public void Zip_not_works_with_null() {

        String nullable = null;
        String inputZipNullable = Rle.zip(nullable);
        String inputUnzipNullable = Rle.unzip(nullable);
        Assertions.assertEquals("", inputZipNullable);
        Assertions.assertEquals("", inputUnzipNullable);

    }

    @Test
    public void Zip_returns_empty_when_input_is_empty(){

        String empty = "";
        String inputZipEmpty = Rle.zip(empty);
        String inputUnzipEmpty = Rle.unzip(empty);
        Assertions.assertEquals("", inputZipEmpty);
        Assertions.assertEquals("", inputUnzipEmpty);

    }

    @Test
    public void Zip_must_works_correctly(){

        String input = GenerateStringUtils.genStrRandomRepeatableChars(3,5,40);
        String zip = Rle.zip(input);
        String expected = Rle.unzip(zip);
        Assertions.assertEquals(expected, input);

    }

}
