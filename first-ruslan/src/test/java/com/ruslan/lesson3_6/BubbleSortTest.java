package com.ruslan.lesson3_6;

import com.ruslan.GenerateArrayUtils;
import com.ruslan.lesson1.BubbleSort;
import com.ruslan.lesson1.homework.selectionsort.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void BubbleSort_should_return_null_when_array_is_null() {

        int[] array = null;
        new BubbleSort().sort(array);

        Assertions.assertArrayEquals(null, array);

    }

    @Test
    public void BubbleSort_should_work_correctly() {

        int[] input1 = new int[]{1};
        new BubbleSort().sort(input1);
        int[] expected1 = new int[]{1};
        Assertions.assertArrayEquals(expected1, input1);

        int[] expected2 = GenerateArrayUtils.sortedArray(-99, 99);
        int[] input2 = GenerateArrayUtils.copyAndShuffleArray(expected2);
        SelectionSort.sort(input2);
        Assertions.assertArrayEquals(expected2, input2);

        int[] input3 = GenerateArrayUtils.randomElementsArray(10, 25, 50);
        int[] expected3 = Arrays.copyOf(input3, 50);
        Arrays.sort(expected3);
        SelectionSort.sort(input3);
        Assertions.assertArrayEquals(expected3, input3);

    }

}
