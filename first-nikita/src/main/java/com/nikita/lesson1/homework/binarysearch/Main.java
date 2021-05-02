package com.nikita.lesson1.homework.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] array= new int[]{1,3,5,7,9,2,4,6,8};
        Arrays.sort(array);
        System.out.println(BinarySearch.binary(array,7));
        System.out.println(BinarySearch.binary(array,1));
        System.out.println(BinarySearch.binary(array,9));
        System.out.println(BinarySearch.binary(array,11));
    }
}

