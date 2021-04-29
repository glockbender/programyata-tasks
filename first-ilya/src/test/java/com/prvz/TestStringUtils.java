package com.prvz;

import java.util.Random;

public class TestStringUtils {

    public static String generateRandom(int length) {

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + random.nextInt(26));
            sb.append(randomChar);
        }

        return sb.toString();
    }

    /**
     * Генерирует строку с периодически повторяющимися символами
     *
     * @param minRepeatLength минимальная длина повторяющихся символов
     * @param maxRepeatLength максимальная длина повторяющихся символов
     * @param length          длина итоговой строки
     * @return сгенерированная строка
     */
    // min = 3, max = 5, length = 10
    // 4 aaaa
    // 4 aaaabbbb
    // 3 aaaabbbbccc
    public static String generateRepeatable(int minRepeatLength, int maxRepeatLength, int length) {

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        int generatedLength = 0;

        while (generatedLength < length) {

            int lengthRemain = length - generatedLength;

            int min = Math.min(lengthRemain, minRepeatLength);
            int max = Math.min(lengthRemain, maxRepeatLength);

            int currentRepeatLength = max - min > 0 ? min + random.nextInt(max - min) : min;
            char randomChar = (char) ('a' + random.nextInt(26));

            for (int i = 1; i <= currentRepeatLength; i++) {
                sb.append(randomChar);
                generatedLength++;
            }
        }

        return sb.toString();
    }

}
