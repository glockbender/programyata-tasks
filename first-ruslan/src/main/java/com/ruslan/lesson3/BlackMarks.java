package com.ruslan.lesson3;

import java.util.Arrays;

public class BlackMarks {

    public static String sort(String s) {

        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        StringBuilder zipped = new StringBuilder();

        char pivot = chars[0];

        int counter = 1;

        if (chars.length == 1) {
            counter = 1;
            zipped.append(counter);
        }

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];

            if (current == pivot) {

                counter++;

            } else {
                zipped.append(counter);
                counter = 1;

            }
            pivot = current;

            if (i == chars.length - 1) {

                zipped.append(counter);

            }


        }

        String y = zipped.toString();

        char[] truemaker = y.toCharArray();

        Arrays.sort(truemaker);

        int counterTM = 0;
        int pivotTM = truemaker[0];


        for (int j = 0; j < truemaker.length; j++) {



            char current1 = truemaker[j];

            if (current1 != pivotTM) {

                counterTM++;

            }

            pivotTM = current1;


            if (j == truemaker.length - 1) {

                System.out.println(counterTM);

            }


        }

        if (counterTM > 1) {
            return ("NO");
        } else if (truemaker.length <= 1) {
            return "YES";
        } else if (counterTM == 0) {
            return ("YES");
        } else if (truemaker[0] == 1 | truemaker[truemaker.length - 1] - truemaker[truemaker.length - 2] == 1) {
            return ("YES");
        } else if (truemaker[0] == truemaker[1] & truemaker[truemaker.length - 1] == truemaker[truemaker.length - 2] & counterTM > 0) {
            return ("NO");
        } else  {
            return ("NO");
        }


    }


    public static void main(String[] args) {

        String unsorted = "abbac";

        System.out.println(BlackMarks.sort(unsorted));

    }

}
