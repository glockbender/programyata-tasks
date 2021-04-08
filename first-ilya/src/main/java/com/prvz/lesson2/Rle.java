package com.prvz.lesson2;

public class Rle {

    public static void main(String[] args) {

        String unzipped = "AABBBBCCCCCCDDDEELVCNNNN";

        Rle rle = new Rle();

        String zipped = rle.zip(unzipped);

        String unzipped2 = rle.unzip(zipped);

        System.out.println(zipped);
        System.out.println(unzipped2);
    }

    /*
     AABBBBCCCCCCDDDEELVCNNNN
     A2B4C6D3E2LVCN4
     */
    public String zip(String unzipped) {

        if (unzipped.length() == 1) {
            return unzipped;
        }

        StringBuilder result = new StringBuilder();

        char[] chars = unzipped.toCharArray();

        int counter = 1;

        for (int i = 0; i < chars.length - 1; i++) {

            // проверка последнего символа

            char element = chars[i];
            char nextElement = chars[i + 1];

            if (element == nextElement) {
                counter++;
            } else {

                result.append(element);
                if (counter > 1) {
                    result.append(counter);
                }
                counter = 1;

            }
        }

        result.append(chars[chars.length - 1]);
        if (counter > 1) {
            result.append(counter);
        }

        return result.toString();

    }

    // EXTRA TASK
   public String unzip(String zipped) {
  
        char[] chars = zipped.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length - 1; ) {

            char element = chars[i];
            char nextElement = chars[i + 1];

            if (Character.isDigit(nextElement)) {
                int repeats = Character.getNumericValue(nextElement);
                for (int j = 0; j < repeats; j++) {
                    result.append(element);
                }
                i += 2;
            } else {
                result.append(element);
                i++;
            }

        }

        char lastChar = zipped.charAt(zipped.length() - 1);

        if (!Character.isDigit(lastChar)) {
            result.append(lastChar);
        }

        return result.toString();

    }

}
