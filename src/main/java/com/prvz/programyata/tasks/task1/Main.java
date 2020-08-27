package com.prvz.programyata.tasks.task1;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};

        int find = 3;
        int find2 = 100;

        BinarySearchJava binSearch = new BinarySearchJava();

        boolean found1 = binSearch.search(arr, find);
        boolean found2 = binSearch.search(arr, find2);

        System.out.println(found1);

        System.out.println(found2);

        int[] arr2 = new int[100000000];

        int i = 1;

        for (int j = 0; j < 100000000; j++) {
            arr2[j] = i++;
        }

        long time = System.nanoTime();

        System.out.println(binSearch.search(arr2, 100000001));

        System.out.println("Total time: " + (System.nanoTime() - time));

        time = System.nanoTime();

        System.out.println(binSearch.dumbSearch(arr2, 100000001));

        System.out.println("Total time: " + (System.nanoTime() - time));


    }
}
