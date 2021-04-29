package com.ruslan;

import java.util.Random;

public class GenerateStringUtils {

    public static String genStrRandomRepeatableChars(int minRepeats, int maxRepeats, int length) {

        StringBuilder rrc = new StringBuilder();

        Random rnd = new Random();

        int generatedLength = 0;

        while (length > generatedLength) {

            int remain = length-generatedLength;

            int min = Math.min(remain, minRepeats);
            int max = Math.min(remain, maxRepeats);

            int currentRepeatsLength = max - min > 0 ? min + rnd.nextInt(max-min) : min;
            char randomChar = (char) ('a' + rnd.nextInt(26));

            for (int i = 1; i <= currentRepeatsLength; i++) {

                rrc.append(randomChar);
                generatedLength++;

            }

        }

        return rrc.toString();

    }

}
