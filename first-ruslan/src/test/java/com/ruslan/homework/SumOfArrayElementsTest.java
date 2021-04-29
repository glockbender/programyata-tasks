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
        Assertions.assertEquals(0, nullable);

    }

    @Test
    public void SumOfArrayElements_must_works_correctly() {

        GenerateArrayUtils.sortedArray(0, 10);

    }

}
