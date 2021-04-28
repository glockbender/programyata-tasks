package com.nikita.lesson1.homework.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count, first, last;
        Scanner scan = new Scanner(System.in);
        System.out.println(" Введите необходимое количество элементов: ");
        int num = scan.nextInt();
        int[] array = new int[num];
        System.out.println("Введите " + num + " чисел ");
        for (count = 0; count < num; count++)
            array[count] = scan.nextInt();
        Arrays.sort(array);
        System.out.println("Введите элемент для бинарного поиска: ");
        int item = scan.nextInt();
        first = 0;
        last = num - 1;
        BinarySearch.binary(array, item);
    }
}

