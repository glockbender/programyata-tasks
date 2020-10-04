package com.prvz.programyata.tasks.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {

    private IOUtils() {}

    /**
     * Данный метод выводит в консоль сообщение из параметра message и затем ожидает введение строки в консоли.
     * По нажатию Enter ввод считается завершенным.
     * Прочитанная из консоли строка возвращается в виде результата выполнения метода
     * @param message сообщение, выводящееся перед чтением данных из консоли
     * @return результат чтения из консоли
     */
    public static String readLineFromConsole(String message) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(message);
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Something went wrong");
            throw new RuntimeException(e);
        }
    }

}
