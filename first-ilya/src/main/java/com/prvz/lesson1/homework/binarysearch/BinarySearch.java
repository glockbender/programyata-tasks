package com.prvz.lesson1.homework.binarysearch;


/**
 * Лучшее время сортировки массива - O(N * logN),
 * а лучше время поиска в упорядоченном - O(logN),
 * при этом лучшее время поиска для простого прохода по элементам в неупорядоченном массиве - O(N).
 *
 * Следовательно, для операции сортировки и поиска по упорядоченному массиву
 * итоговая сложность - O(N * logN + logN) = O(N * logN) -- показать на графике
 *
 * Данная сложность по определению выше, чем O(N)
 *
 * Поэтому для эффективного использования данной цепочки алгоритмов
 * подразумевается предварительная сортировка данных и частый поиск во время работы приложения
 *
 * дан массив 10 эл-тов, ищем число 4
 * {0,1,2,3,4,5,6,7,8,9} - 4 => 4
 * Выбираем опорный элемент как половину разницы между наибольшим и наименьшим индексом,
 * вычитаемой из значения большего индекса
 * {0,1,2,3,4,[5],6,7,8,9}
 * Сравниваем значение опорного элемента с искомым
 * 4 < [5]
 * Если элемент больше искомого, двигаем наибольший индекс на (опорный - 1)
 * {0,1,2,3,4}
 * Заново ищем опорный индекс
 * {0,1,[2],3,4}
 * Сравниваем значение опорного элемента с искомым
 * 4 > [2]
 * Если элемент меньше искомого, двигаем наименьший индекс на (опорный + 1)
 * {3, 4}
 * Длина оставшегося массива = 2
 * => highIdx - lowIdx <= 1
 * Прибегаем к очевидному сравнению
 * [3] < 4,
 * [4] == 4
 * PROFIT!!!
 */
public class BinarySearch {

    public int search(int element, int[] from) {

        int lowIdx = 0;
        int highIdx = from.length - 1;

        int highMinusLow = highIdx - lowIdx;

        while (highMinusLow > 1) {
            int pivot = highIdx - (highMinusLow / 2);
            int pivotValue = from[pivot];
            if (element == pivotValue) {
                return pivot;
            }
            if (element > pivotValue) {
                lowIdx = pivot + 1;
            } else {
                highIdx = pivotValue - 1;
            }
            highMinusLow = highIdx - lowIdx;
        }

        if (from[lowIdx] == element)
            return lowIdx;
        if (from[highIdx] == element)
            return highIdx;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        BinarySearch search = new BinarySearch();

        System.out.println(search.search(2, arr));
        System.out.println(search.search(7, arr));
        System.out.println(search.search(11, arr));
    }

}
