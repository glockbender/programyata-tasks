package com.prvz.task3;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortJava {

    public <T extends Comparable<T>> T[] quickSortRecursive(T[] array, Sort sort) {

        int length = array.length;

        int awaitingCompare;
        if (sort == Sort.DESC) {
            awaitingCompare = 1;
        } else {
            awaitingCompare = -1;
        }

        if (length == 2) {
            if (array[0].compareTo(array[1]) != awaitingCompare) {
                swapTwoElementsArray(array);
            }
        } else if (length > 2) {
            int pivotIdx = ThreadLocalRandom.current().nextInt(length);
            T pivotElement = array[pivotIdx];
            int maxSideArrayLength = length - 1;
            Class<?> componentType = array.getClass().getComponentType();
            T[] left = (T[]) Array.newInstance(componentType, maxSideArrayLength);
            T[] right = (T[]) Array.newInstance(componentType, maxSideArrayLength);
            int leftIdx = 0;
            int rightIdx = 0;

            for (int i = 0; i < array.length; i++) {
                if (i == pivotIdx) {
                    continue;
                }
                T element = array[i];
                if (pivotElement.compareTo(element) != awaitingCompare) {
                    left[leftIdx++] = element;
                } else {
                    right[rightIdx++] = element;
                }
            }

            left = leftIdx == 0 ? (T[]) Array.newInstance(componentType, 0) :
                Arrays.copyOf(left, leftIdx);

            right = rightIdx == 0 ? (T[]) Array.newInstance(componentType, 0) :
                Arrays.copyOf(right, rightIdx);

            T[] result = concat(quickSortRecursive(left, sort), pivotElement, quickSortRecursive(right, sort));

            System.arraycopy(result, 0, array, 0, result.length);
        }
        return array;
    }

    private <T> void swapTwoElementsArray(T[] array) {
        T swapped = array[0];
        array[0] = array[1];
        array[1] = swapped;
    }

    private <T> T[] concat(@NotNull T[] left, T value, T[] right) {

        T[] result = Arrays.copyOf(left, left.length + right.length + 1);
        result[left.length] = value;

        System.arraycopy(right, 0, result, left.length + 1, right.length);

        return result;
    }

    public enum Sort {
        ASC,
        DESC
    }

}
