package com.ruslan.homework;

import com.ruslan.GenerateArrayUtils;
import com.ruslan.GenerateStringUtils;
import com.ruslan.lesson2.SumOfArrayElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfArrayElementsTest {

    @Test
    public void SumOfArrayElements_must_not_works_with_null() {

        int[] ar = null;
        int nullable = SumOfArrayElements.simpleArraySum(ar);
        Assertions.assertEquals(-1, nullable);

    }

    @Test
    public void SumOfArrayElements_must_not_works_with_arrays_with_zero_length(){

        int[] arr = new int[0];
        int result = SumOfArrayElements.simpleArraySum(arr);
        Assertions.assertEquals(-1,result);

    }

    @Test
    public void SumOfArrayElements_must_works_correctly() {

        int[] arr = GenerateArrayUtils.sortedArray(-10, 10);
        int sumOfArray = SumOfArrayElements.simpleArraySum(arr);
        Assertions.assertEquals(0, sumOfArray);

    }

}
