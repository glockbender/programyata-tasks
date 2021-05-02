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

        int[] array = new int[] {1,1,2,6,24,120,720,5040,40320,362880,3628800};
        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], Factorial.factorial(i));
        }
    }
}
