package com.ruslan.lesson1.homework.binarysearch;

public class BinarySearchMain {

    public static void main(String[] args) {

        int[] array = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6, 7, 7, 7, 7, 8, 8};

        int item = 8;

        int index = new BinarySearch().search(array, item, 0, array.length - 1);

        if (index == -1) {
            System.out.println("Element is not found");
        }  else {
            System.out.println("Index of item are " + index);
        }

    }

}
