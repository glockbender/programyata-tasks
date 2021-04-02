package com.prvz.task1;

public class BinarySearchJava {

    public boolean search(int[] array, int find) {

        boolean result = false;

        int from = 0;
        int to = array.length - 1;

        while (!result) {

            if (from > to) {
                break;
            }

            // ищем индекс среднего элемента
            int midElement = to - (to - from) / 2;

            // получаем средний элемент
            int midValue = array[midElement];

            // если больше искомого, то двигаем правый указатель левее среднего индекса
            if (midValue > find) {
                to = midElement - 1;
                //Иначе если меньше искомого, то двигаем левый указатель правее среднего индекса
            } else if (midValue < find) {
                from = midElement + 1;
            } else {
                //Иначе значение найден
                result = true;
            }
        }

        return result;
    }

    public boolean dumbSearch(int[] array, int find) {

        for (int a : array) {
            if (a == find) {
                return true;
            }
        }
        return false;
    }

}
