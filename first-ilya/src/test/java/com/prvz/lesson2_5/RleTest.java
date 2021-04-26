package com.prvz.lesson2_5;

import com.prvz.TestStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RleTest {

    Rle rle = new Rle();

    @Test
    public void rle_should_works_correctly() {

        String unzipped = TestStringUtils.generateRepeatable(1, 20, 1000);
        System.out.println(unzipped);
        String zipped = rle.zip(unzipped);
        System.out.println(zipped);
        String unzipped2 = rle.unzip(zipped);

        Assertions.assertEquals(unzipped, unzipped2);

    }

}
