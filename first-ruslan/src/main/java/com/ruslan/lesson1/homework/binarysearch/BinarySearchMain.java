package com.ruslan.lesson1.homework.binarysearch;

public class BinarySearchMain extends BinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int item = 10;

        int index = new BinarySearch().search(array, item, 0, array.length - 1);

        if (index < 0) {
            System.out.println("Out of range");
        } else if (index > array.length - 1) {
            System.out.println("Out of range");
        } else {
            System.out.println("Index of item are " + index);
        }

    }

}
