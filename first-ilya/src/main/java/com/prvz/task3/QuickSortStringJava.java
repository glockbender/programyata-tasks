package com.prvz.task3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortStringJava {

    public void quickSortRecursive(String[] array) {

        int length = array.length;

        if (length == 2) {
            if (array[0].compareTo(array[1]) > 0) {
                swapTwoElementsArray(array);
            }
        } else if (length > 2) {
            int pivotIdx = ThreadLocalRandom.current().nextInt(length);
            String pivotElement = array[pivotIdx];
            int maxSideArrayLength = length - 1;
            String[] left = new String[maxSideArrayLength];
            String[] right = new String[maxSideArrayLength];
            int leftIdx = 0;
            int rightIdx = 0;

            for (int i = 0; i < array.length; i++) {
                if (i == pivotIdx) {
                    continue;
                }
                String element = array[i];
                if (pivotElement.compareTo(element) > 0) {
                    left[leftIdx++] = element;
                } else {
                    right[rightIdx++] = element;
                }
            }

            if (leftIdx == 0) {
                left = new String[0];
            } else {
                left = Arrays.copyOf(left, leftIdx);
            }

            if (rightIdx == 0) {
                right = new String[0];
            } else {
                right = Arrays.copyOf(right, rightIdx);
            }

            quickSortRecursive(left);

            quickSortRecursive(right);

            String[] result = concat(left, pivotElement, right);

            System.arraycopy(result, 0, array, 0, result.length);
        }
    }

    private void swapTwoElementsArray(String[] array) {
        String swapped = array[0];
        array[0] = array[1];
        array[1] = swapped;
    }

    private String[] concat(String[] left, String value, String[] right) {

        String[] result = Arrays.copyOf(left, left.length + right.length + 1);
        result[left.length] = value;

        System.arraycopy(right, 0, result, left.length + 1, right.length);

        return result;
    }

}
