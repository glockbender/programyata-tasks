package com.nikita.lesson3.homework3;

import java.util.Scanner;

public class HackerRankStaticInitializer {

    static Scanner scanner = new Scanner(System.in);
    static int B = scanner.nextInt();
    static int H = scanner.nextInt();
    static boolean flag = true;

    static {
        if ((B <= 0) || (H <= 0)) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        int area = 0;
        if (flag) {
            area = B * H;
        }
        System.out.println(area);
    }
}

