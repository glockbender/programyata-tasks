package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson2.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RleTest {
    @Test
    public void Rle_does_not_work_with_null() {
        String line = null;
        String rleLine = new Rle().zip(line);
        Assertions.assertEquals(line ,rleLine);
    }
//        @Test
//        public void Rle_сorrect_work_with_zero(){
//        String line= "";
//        String rleLine= new  Rle().zip(line);
//
//
//
//
//    }
}
