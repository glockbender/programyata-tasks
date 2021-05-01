package com.nikita.lesson3_6;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson1.homework.binarysearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void BinarySearch_works_correctly1() {
        int[] array = ArrayTestUtils.generate(1, 10);
        int item = BinarySearch.binary(array, 4);
        Assertions.assertEquals(3, item);
    }

    @Test
    public void BinarySearch_works_correctly2() {
        int[] array = ArrayTestUtils.generate(1, 55);
        int item = BinarySearch.binary(array, 1);
        Assertions.assertEquals(0, item);
    }

    @Test
    public void BinarySearch_works_correctly3() {
        int[] array = ArrayTestUtils.generate(1, 55);
        int item = BinarySearch.binary(array, 55);
        Assertions.assertEquals(54, item);
    }

    @Test
    public void BinarySearch_works_correctly4() {
        int[] array = ArrayTestUtils.generate(1, 20);
        int item = BinarySearch.binary(array, 50);
        Assertions.assertEquals(-1, item);
    }

    @Test
    public void BinarySearch_does_not_work_with_NULL() {
        int[] array = null;
        int item = BinarySearch.binary(array, 5);
        Assertions.assertEquals(-1, item);
    }
}
