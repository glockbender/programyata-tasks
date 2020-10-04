package com.prvz.programyata.tasks.task1;

import com.prvz.programyata.tasks.utils.IOUtils;

public class Main {

    public static void main(String[] args) {

        String arrayIn = IOUtils.readLineFromConsole(
            "Enter a sorted array to search and press \"Enter\" key.\nNote numbers must be divided by ','"
        );
        String findIn = IOUtils.readLineFromConsole(
            "Enter the desired number and press \"Enter\" key"
        );

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
                // Обязательно вызываем trim на строке,
                // т.к. при разбиении строки на числа, после или до запятых могли появиться лишние пробелы
                // trim удаляет все пробелы перед первым и после последнего символа
                arrayTransformed[i] = Integer.parseInt(split[i].trim());
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
