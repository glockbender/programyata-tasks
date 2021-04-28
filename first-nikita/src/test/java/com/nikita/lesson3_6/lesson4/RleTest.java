package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson2.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RleTest {
    Rle rle= new Rle();
    @Test
    public void Rle_does_not_work_with_null_or_empty_line() {
        String line = null;
        String rleLine = rle.zip(line);

        String newLine="";
        String rleNewLine= rle.zip(newLine);

    }
}
