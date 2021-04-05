package com.prvz.utils;

public class ArrayUtils {


    // Добавить проверки корректности граничных значений
    // Объяснить, почему подобный подход - не лучшая идея:
    // - меньший контроль изменения;
    // - вызов метода, вместо трех строк;
    // - внешний код мог уже выполнить проверки, либо сразу проставить корректные значения
    public static void swap(int fromIdx, int toIdx, int[] array) {

        int temp = array[fromIdx];
        array[fromIdx] = array[toIdx];
        array[toIdx] = temp;

    }

}
