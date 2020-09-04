package com.prvz.programyata.tasks.task3;

import com.prvz.programyata.tasks.utils.IOUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String arrayIn = IOUtils.readLineFromConsole(
            "Enter a integer array to search and press \"Enter\" key.\nNote numbers must be divided by ','"
        );

        // Проверяем, что введенный массив не null и не пустой
        if (arrayIn == null || arrayIn.isBlank()) {
            System.err.println("There's no data in array");
            return;
        }

        // С помощью split переводим строку с числами (пока что в строковом представлении),
        // разделенными запятыми в массив (пока что строк).
        // Для этого указываем разделитель, по которому и будет произведен перевод данных в массив
        String[] split = arrayIn.split(",");
        // Дополнительно проверяем, что массив в итоге не пустой
        if (split.length == 0) {
            System.err.println("Array is empty");
            return;
        }

        // Best way to array transform: Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
        // Создаем массив int'ов, куда будем перегонять массив строк
        Integer[] arrayTransformed = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                // Парсим строку в число
                arrayTransformed[i] = Integer.valueOf(split[i]);
            } catch (NumberFormatException nfe) {
                System.err.println("Illegal character in array: " + split[i]);
                return;
            }
        }

        Integer[] result = new QuickSortJava().quickSortRecursive(arrayTransformed, QuickSortJava.Sort.ASC);

        System.out.println("Sorted array:");
        System.out.println(Arrays.stream(result).map(String::valueOf).collect(Collectors.joining(",")));

    }

}
