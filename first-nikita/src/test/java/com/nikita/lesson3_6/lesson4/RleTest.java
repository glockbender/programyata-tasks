package com.nikita.lesson3_6.lesson4;

import com.nikita.StringTestUtils;
import com.nikita.lesson3.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RleTest {

    @Test
    public void Rle_does_not_work_with_null_or_empty_line() {
        String line = null;
        String rleLine = Rle.zip(line);
        Assertions.assertEquals("", rleLine);

        String newLine = "";
        String rleNewLine = Rle.zip(newLine);
        Assertions.assertEquals("", rleNewLine);
    }
    @Test
    public void Rle_works_correctly() {
        String s = StringTestUtils.generateStringRandom(26);
        String zipped = Rle.zip(s);
        String unzipped = Rle.unzipped(zipped);
        Assertions.assertEquals(s, unzipped);
    }
}
