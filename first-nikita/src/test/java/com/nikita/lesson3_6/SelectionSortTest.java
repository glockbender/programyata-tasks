package com.nikita.lesson3_6;

import com.nikita.lesson1.homework.selectionsort.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {
    @Test
    public void SelectionSorting_works_correctly() {
        int[] array = new int[]{9, 8, 6, 4, 2, 1};
        int[] correctArray = new int[]{1, 2, 4, 6, 8, 9};
        new SelectionSort().sort(array);
        Assertions.assertArrayEquals(correctArray, array);
    }

    @Test
    public void SelectionSorting_does_not_work_with_NULL() {
        int[] array = null;
        new SelectionSort().sort(array);
    }
}
