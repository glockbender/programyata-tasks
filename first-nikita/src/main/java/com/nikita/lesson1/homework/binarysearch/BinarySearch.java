package com.nikita.lesson1.homework.binarysearch;

public class BinarySearch {
    public static int binary(int[] array, int item) {
        if (array == null) {
            return 0;
        }
        int first = 0;
        int last = array.length - 1;
        int index = -1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (array[mid] < item) {
                first = mid + 1;
            } else if (array[mid] > item) {
                last = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        if (first <= last) {
            System.out.println(item + " является " + ++index + " элементом в массиве");
        } else {
            System.out.println(" Нужный элемент в массиве не найден! ");
        }
        return -1;

    }

}
