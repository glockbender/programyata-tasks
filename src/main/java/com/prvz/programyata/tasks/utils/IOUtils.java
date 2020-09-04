package com.prvz.programyata.tasks.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {

    private IOUtils() {}

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
