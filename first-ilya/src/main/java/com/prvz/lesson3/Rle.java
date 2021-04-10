package com.prvz.lesson3;

public class Rle {

    //

    /*
     AABBBBCCCCCCDDDEELVCNNNN
     A2B4C6D3E2LVCN4
     */
    public String zip(String unzipped) {

        char[] chars = unzipped.toCharArray();

        StringBuilder result = new StringBuilder();

        char pivotChar = chars[0];
        int counter = 1;

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];

            if (current == pivotChar) {
                counter++;
            } else {
                result.append(pivotChar);
                if (counter > 1) {
                    result.append(counter);
                }
                pivotChar = current;
                counter = 1;
            }

        }

        result.append(pivotChar);
        if (counter > 1) {
            result.append(counter);
        }

        return result.toString();

    }

    /*
     AB2C2
     ABBCC

     A2B4C6D3E2LVCN4
     AABBBBCCCCCCDDDEELVCNNNN
     */
    public String unzip(String zipped) {

        char[] chars = zipped.toCharArray();

        StringBuilder result = new StringBuilder();

        char pivotChar = chars[0];

        for (int i = 1; i < zipped.length(); i++) {

            char current = chars[i];

            // Если символ - цифра
            if (Character.isDigit(current)) {
                // Узнаем оставшееся кол-во символов, которые мы еще не проходили в цикле по i
                int charsLeft = chars.length - 1 - i;
                // Получаем числовое значение текущего символа
                int charsCount = Character.getNumericValue(current);
                // Если осталось более одного непройденного символа
                if (charsLeft > 1) {
                    // Итерируемся по непройденным символам
                    for (int j = i + 1; j < chars.length; j++) {
                        char inner = chars[j];
                        // Если символ - цифра
                        if (Character.isDigit(inner)) {
                            // Берем первоначальное числовое значение, умножаем на 10 и прибавляем новую цифру
                            // Т.е. было число 2. Следующая цифра 1. Надо получить 21. 2 * 10 + 1
                            charsCount = charsCount  * 10 + Character.getNumericValue(inner);
                            // т.к. мы уже прошлись по следующему элементу и прочитали его значение,
                            // счетчик основного цикла нужно уввеличить
                            // Иначе в основном цикле мы вновь встретим это число
                            i++;
                        } else {
                            // Если символ не цифра - дальше искать смысла нет, выходим из цикла
                            break;
                        }
                    }
                }

                for (int j = 1; j < charsCount; j++) {
                    result.append(pivotChar);
                }
            } else {
                result.append(pivotChar);
                pivotChar = current;
            }

        }

        result.append(pivotChar);

        return result.toString();
    }


    public static void main(String[] args) {
        String testString = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        System.out.println(testString.length());
        Rle rle = new Rle();
        String zipped = rle.zip(testString);
        String unzipped = rle.unzip(zipped);

        System.out.println(zipped);
        System.out.println(unzipped);
        System.out.println(unzipped.length());
    }

}
