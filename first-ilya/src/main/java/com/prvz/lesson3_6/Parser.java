package com.prvz.lesson3_6;

import java.io.*;

public class Parser {

    // hello_123 -> String[]{"hello","123"}
    public static int parseIntPostfixAtString(String s) throws ParsingException {

        if (s == null) {
            throw new ParsingException("String is null");
        }

        if (s.isBlank()) {
            throw new ParsingException("String is empty or blank");
        }

        if (!s.contains("_")) {
            throw new ParsingException("String doesn't have splitter");
        }

        String[] split = s.split("_");

        if (split.length > 2) {
            throw new ParsingException("Unknown string format");
        }

        try {
            return Integer.parseInt(split[1]);
        } catch (NumberFormatException nfe) {
            throw new ParsingException("Cannot parse postifx as number", nfe);
        }


    }

    public static void main(String[] args) {

        File f = new File("G:\\parse.txt");

        FileReader fr;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return;
        }

        BufferedReader br = new BufferedReader(fr);

        try {
            String line = br.readLine();

            while (line != null) {
                System.out.println(parseIntPostfixAtString(line));

                line = br.readLine();
            }
            System.out.println("FILE READ");
        } catch (IOException ioe) {
            System.out.println("IO PROBLEMS");
        } finally {
            System.out.println(f.delete());
        }

        System.out.println("DONE");

    }

    // Throwable - базовый класс

    // Exception - проверяемые искл

    // RuntimeException - непроверяемые искл

}
