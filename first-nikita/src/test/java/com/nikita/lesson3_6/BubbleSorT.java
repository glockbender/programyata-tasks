package com.nikita.lesson3_6;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson1.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BubbleSortTest {

    @Test
    public void BubbleSorting_works_correctly() {
        int[] array = new int[]{1, 4, 2, 3, 6, 5};
        int[] correctArray = new int[]{1, 2, 3, 4, 5, 6};
        BubbleSort.sort(array);
        Assertions.assertArrayEquals(correctArray, array);

        correctArray = ArrayTestUtils.generate(1, 100);
        array=ArrayTestUtils.copyAndShuffle(correctArray);
        BubbleSort.sort(array);
        Assertions.assertArrayEquals(correctArray, array);

        int [] arrayBubleSort= ArrayTestUtils.generateRandom(-50,50,20);
        int [] arraySort=Arrays.copyOf(arrayBubleSort,20);
        BubbleSort.sort(arrayBubleSort);
        Arrays.sort(arraySort);
        Assertions.assertArrayEquals(arrayBubleSort,arraySort);

    }

    @Test
    public void BubbleSort_does_not_work_with_null() {
        int[] ar= null;
        BubbleSort.sort(ar);

    }
}







