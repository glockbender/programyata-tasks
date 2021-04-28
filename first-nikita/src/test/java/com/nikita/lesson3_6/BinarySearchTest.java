package com.nikita.lesson3_6;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson1.homework.binarysearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void BinarySearch_works_correctly1() {
        int[] array = ArrayTestUtils.generate(1, 10);
        int item = 4;
        binarySearch.binary(array, item);
        Assertions.assertEquals(item, 4);
    }

    @Test
    public void BinarySearch_works_correctly2() {
        int[] array = ArrayTestUtils.generate(1, 55);
        int item = 1;
        binarySearch.binary(array, item);
        Assertions.assertEquals(item, 1);
    }

    @Test
    public void BinarySearch_works_correctly3() {
        int[] array = ArrayTestUtils.generate(1, 55);
        int item = 55;
        binarySearch.binary(array, item);
        Assertions.assertEquals(item, 55);
    }

    @Test
    public void BinarySearch_works_correctly_without_the_needed_element() {
        int[] array = ArrayTestUtils.generate(1, 20);
        int element = 20;
        binarySearch.binary(array, element);
        Assertions.assertEquals(element, 20);
    }

    @Test
    public void BinarySearch_does_not_work_with_NULL() {
        int[] array = null;
        new BinarySearch().binary(array, 5);

    }
}
