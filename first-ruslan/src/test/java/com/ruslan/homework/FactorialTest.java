package com.ruslan.homework;

import com.ruslan.GenerateArrayUtils;
import com.ruslan.lesson2.homework.factorial.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void Factorial_must_return_minus_one_if_input_less_than_zero() {

        int n = -2;
        int input = Factorial.factorial(n);
        Assertions.assertEquals(-1, input);

    }

    @Test
    public void Factorial_must_works_correctly() {

        int[] array = GenerateArrayUtils.sortedArray(0, 10);

        int expected_i = 1;

        for (int i = 0; i < array.length; i++) {

            int n = array[i];
            int result_i = Factorial.factorial(n);
            if (n != 0) {
                expected_i = expected_i * n;
            } else
                Assertions.assertEquals(expected_i, result_i);

        }

    }

}
