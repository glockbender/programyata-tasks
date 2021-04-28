package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson2.FactorialSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialSumTest {
    @Test
    public void FactorialSum_works_correctly(){
        int i = 2;
        int result = new FactorialSum().factorialsum(i);
        Assertions.assertEquals(result,2);
    }
    @Test
    public void FactorialSum_сorrect_work_with_zero(){
        int i =0;
        int result = new FactorialSum().factorialsum(i);
        Assertions.assertEquals(result,1);
    }

}
