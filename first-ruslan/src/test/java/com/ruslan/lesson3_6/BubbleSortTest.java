package com.ruslan.lesson3_6;

import com.ruslan.lesson1.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class BubbleSortTest {

    @Test
    public void BubbleSort_should_throw_Exception_when_array_is_null() {

        int[] array = null;
        new BubbleSort().sort(array);

        Assertions.assertArrayEquals(null, array);

    }

    @Test
    public void BubbleSort_should_work_correctly() {

        int[] input1 = new int[]{1, 2, 5, 4};
        new BubbleSort().sort(input1);
        int[] expected1 = new int[]{1, 2, 4, 5};
        Assertions.assertArrayEquals(expected1, input1);

        int[] input2 = new int[]{1};
        new BubbleSort().sort(input2);
        int[] expected2 = new int[]{1};
        Assertions.assertArrayEquals(expected2, input2);

        int[] input3 = new int[]{1, 2, -5, 4};
        new BubbleSort().sort(input3);
        int[] expected3 = new int[]{-5, 1, 2, 4};
        Assertions.assertArrayEquals(expected3, input3);

        int[] expected4 = new int[1000];
        int value = 0;

        for (int i = 0; i < 1000; i++) {

            value++;
            expected4[i] = value;

        }

        int[] input4 = new int[1000];
        int value1 = 0;

        for (int j = 0; j < 1000; j++) {

            value1++;
            input4[j] = value1;

        }

        Random rnd = new Random();

        for (int j = 0; j < 1000; j++) {

            int index = rnd.nextInt(j+1);
            int a = input4[index];
            input4[index] = input4[j];
            input4[j] = a;

        }

        new BubbleSort().sort(input4);
        Assertions.assertArrayEquals(expected4, input4);


    }

}
