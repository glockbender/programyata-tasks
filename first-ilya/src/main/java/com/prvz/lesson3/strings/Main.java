package com.prvz.lesson3.strings;

import com.prvz.lesson3.ArrayUtils;
import com.prvz.utils.IOUtils;

public class Main {

    public static void main(String[] args) {

        String read = IOUtils.readLineFromConsole("Введите числа, разделенные запятыми");

        int[] ints = ArrayUtils.parseStringToIntArray(read, ",");

        System.out.println();

    }

}
