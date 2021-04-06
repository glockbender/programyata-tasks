package com.prvz.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.function.Function;

public class IOUtils {

    private IOUtils() {
    }

    /**
     * Данный метод выводит в консоль сообщение из параметра message и затем ожидает введение строки в консоли.
     * По нажатию Enter ввод считается завершенным.
     * Прочитанная из консоли строка возвращается в виде результата выполнения метода
     *
     * @param message сообщение, выводящееся перед чтением данных из консоли
     * @return результат чтения из консоли
     */
    public static String readLineFromConsole(String message) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(message);
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Something went wrong");
            throw new RuntimeException(e);
        }
    }

    public static String[] readStringAsStringArray(String read, String delimiter) {
        // Проверяем, что введенный массив не null и не пустой
        if (read == null || read.isBlank()) {
            System.err.println("There's no data in reading string");
            return null;
        }

        // С помощью split переводим строку с числами (пока что в строковом представлении),
        // разделенными запятыми в массив (пока что строк).
        // Для этого указываем разделитель, по которому и будет произведен перевод данных в массив
        String[] split = read.split(delimiter);
        // Дополнительно проверяем, что массив в итоге не пустой
        if (split.length == 0) {
            System.err.println("Array is empty");
            return null;
        }

        return split;
    }

    public static int[] readStringAsIntArray(String read, String delimiter) {

        String[] split = readStringAsStringArray(read, delimiter);

        if (split == null) {
            return null;
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
                return null;
            }
        }

        return arrayTransformed;
    }

    public static <T> T[] readStringAsArray(
        String read,
        String delimiter,
        Class<T> typeClass,
        Function<String, T> toTypeFunction
    ) {

        String[] split = readStringAsStringArray(read, delimiter);

        if (split == null) {
            return null;
        }

        T[] resultArray = (T[]) Array.newInstance(typeClass, split.length);

        for (int i = 0; i < split.length; i++) {
            try {
                resultArray[i] = toTypeFunction.apply(split[i].trim());
            } catch (Exception expected) {
                System.err.println("Cannot convert String to " +
                    typeClass.getSimpleName() +
                    " object. Value: " + split[i]
                );
                return null;
            }
        }

        return resultArray;
    }

    public static Integer[] readStringAsIntegerArray(
        String read,
        String delimiter
    ) {
        return IOUtils.readStringAsArray(read, delimiter, Integer.class, Integer::parseInt);
    }

}
