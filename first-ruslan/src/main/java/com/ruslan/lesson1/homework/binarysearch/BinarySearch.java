package com.ruslan.lesson1.homework.binarysearch;

public class BinarySearch {

    public int search(int[] array, int item, int low, int high) {

        if (array == null) {
            return 0;
        }

        int index = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int sought = array[mid];

            if (sought > item) {
                high = mid - 1;
            } else if (sought < item) {
                low = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;

    }

}


