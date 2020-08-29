package com.prvz.programyata.tasks.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        String arrayIn = null;
        String findIn = null;

        // Почитать про: try with resources, java IO
        // Как ввести данные с консоли: https://data-flair.training/blogs/read-java-console-input/
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(
                "Enter a sorted array to search and press \"Enter\" key.\nNote numbers must be divided by ','");
            arrayIn = reader.readLine();
            System.out.println("Enter the desired number and press \"Enter\" key");
            findIn = reader.readLine();
        } catch (IOException e) {
            System.err.println("Something went wrong");
        }

        // Проверяем, что введенный массив не null и не пустой
        if (arrayIn == null || arrayIn.isBlank()) {
            System.err.println("There's no data in array");
            return;
        }

        // Проверяем, что введенное число не null и не пустое
        if (findIn == null || findIn.isBlank()) {
            System.err.println("Desired number is empty");
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
        int[] arrayTransformed = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                // Парсим строку в число
                arrayTransformed[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException nfe) {
                System.err.println("Illegal character in array: " + split[i]);
                return;
            }
        }

        int findTransformed;
        try {
            findTransformed = Integer.parseInt(findIn);
        } catch (NumberFormatException nfe) {
            System.err.println("Illegal desired value: " + findIn);
            return;
        }

        BinarySearchJava binSearch = new BinarySearchJava();

        boolean foundBinary = binSearch.search(arrayTransformed, findTransformed);

        // Сокращенная форма if. Почитать про тернарный оператор
        String resultMessage = foundBinary ? "WAS FOUND" : "WAS NOT FOUND";

        System.out.println("Number: " + findIn + " " + resultMessage + " in the entered array");
    }
}
