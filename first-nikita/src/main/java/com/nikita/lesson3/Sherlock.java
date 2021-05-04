package com.nikita.lesson3;

import java.util.Arrays;

public class Sherlock {
    /**
     * создание сортированного массива символов
     *
     * @param unsorted (несортированная строка)
     * @return сортированную строку
     */
    public static String sortMas(String unsorted) {
        char[] charsArray = unsorted.toCharArray();
        StringBuilder sort = new StringBuilder();
        Arrays.sort(charsArray);
        sort.append(charsArray);
        return sort.toString();
    }

    /**
     * выявление уникальных элементов в отсортированной строке
     *
     * @param sort (отсортированная строка)
     * @return количество уникальных элементов
     */
    public static int uniqueElements(String sort) {
        int elements = 1;
        char[] chars = sort.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                elements++;
            }
        }
        return elements;
    }

    /**
     * подсчитываем количество уникальных элементов
     *
     * @param sort     (отсортированная строка)
     * @param elements (количество уникальных элементов)
     * @return отсортированный массив уникальных элементов
     */
    public static int[] countingUniqueElements(String sort, int elements) {
        int[] repeatElements = new int[elements];
        char[] chars = sort.toCharArray();
        int counter = 1;
        int index = 0;

        for (int i = 0; i < chars.length - 1; i++) {

            if (chars[i] == chars[i + 1]) {
                counter++;

            } else {

                repeatElements[index] = counter;
                index++;
                counter = 1;

            }
        }
        repeatElements[index] = counter;
        Arrays.sort(repeatElements);
        return repeatElements;
    }

    /**
     * проверка условий массива с повторяющимися элементами
     *
     * @param repeatElements (отсортированный массив с повторяющимися элементами)
     * @return результат проверки массива
     */
    public static boolean checkingConditions(int[] repeatElements) {
        boolean condition = false;
        // ( )
        if (repeatElements.length == 0 || repeatElements == null) {
            return true;
        }
        // (4)
        if (repeatElements.length == 1) {
            return true;
        }
        //(1222) (2223)
        if (repeatElements.length == 2) {
            if (Math.abs(repeatElements[1] - repeatElements[0]) == 1 || (repeatElements[1] - repeatElements[0] == 0)) {
                return true;
            }
        }
        int counterDifference = 0;
        for (int i = 0; i < repeatElements.length; i++) {
            if (repeatElements[i] != repeatElements[i + 1]) {
                counterDifference++;
            }
        }
        // (1111)
        if (counterDifference == 0) {
            return true;
        }
        //(1112
        if (counterDifference == 1) {
            return true;
        }
        //(3555)
        if (counterDifference > 1) {
            return false;
        }
        int counter = 1;
        for (int i = 0; i < repeatElements.length - 1; i++) {
            if (repeatElements[i] == repeatElements[i + 1]) {
                counter++;
            } else
                break;
        }
        condition = (repeatElements.length - counter == 1 && repeatElements[repeatElements.length - 1] - repeatElements[repeatElements.length - 2] == 1) || (repeatElements[0] == 1 && counter == 1);

        return condition;
    }

    public static String sherlock(String unsorted) {

        String sortString = sortMas(unsorted);
        System.out.println(sortString);

        int elements = uniqueElements(sortString);
        System.out.println(" уникальные элементы :" + elements);

        int[] repeatElements = countingUniqueElements(sortString, elements);
        System.out.println(Arrays.toString(repeatElements));
        if (checkingConditions(repeatElements)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String string = "abbcc";
        System.out.println(sherlock(string));
    }
}
