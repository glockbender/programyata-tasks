package com.prvz.lesson3;

import java.util.HashMap;
import java.util.Map;

public class SherlockStrings {

    private static final String YES = "YES";
    private static final String NO = "NO";

    static String isValid(String s) {

        int length = s.length();

        if (length < 2) {
            return YES;
        }

        // Максимальное кол-во повторений символа
        int max = 1;

        // if (length > 32) { capacity = length / 2 } else { capacity = length }
        final int capacity = length > 32 ? length / 2 : length;

        // Словарь/мапа, где ключ - символ, а значение - кол-во повторений символа
        final Map<Character, Integer> dictionary = new HashMap<>(capacity, 1L);

        // Проход по всем символам строки
        for (Character ch : s.toCharArray()) {
            // Пытаемся найти значение повторений символа
            Integer count = dictionary.get(ch);
            if (count == null) { // Если такого символа/ключа еще нет в мапе
                //Добавляем в мапу символ и счетчик повторений равный 1
                dictionary.put(ch, 1);
            } else { // Иначе в мапе уже есть такой ключ
                // Кладем в мапу по существующему ключу новое значение счетчика = счетчик + 1
                // Здесь используется предварительный инкремент. Т.е. значение сначала инкрементируется,
                // потом уже записывается в мапу
                dictionary.put(ch, ++count);
                // Также сразу проверяем макс. кол-во повторений символа
                if (count > max) {
                    max = count;
                }
            }
        }
        // Если строка по сути состоит только из повторяющихся одних и тех же букв, она валидна
        if (max == length) {
            return YES;
        }

        // Ищем минимальное кол-во повторений символа
        int min = max;

        // Считаем кол-во групп символов с максимальным числом повторений
        int maxCnt = 0;

        // Проходимся по списку значений из мапы (ключ больше не трогаем)
        for (Integer i : dictionary.values()) {
            // Проверяем минимальное кол-во повторений
            if (i < min) {
                min = i;
            } else if (i == max) { // Если текущее кол-во повторений == максимальному, прибавляем к группе макс символов
                maxCnt++;
            }
        }

        // Если макс. и мин. кол-во повторений равны, все символы повторяются одинаковое кол-во раз
        if (max - min == 0) {
            return YES;
        }

        // Всего символов, занимаемых макс. группой
        int maxLettersLength = max * maxCnt;
        // Всего символов, занимаемых мин. группой
        int minLettersLength = s.length() - maxLettersLength;

        // Если есть только один символ в мин. группе, то его можно удалить по условию задачи
        if (min == 1 && minLettersLength == 1) {
            return YES;
        }
        // Если между повторениями в макс и мин группе разница в 1
        if (max - min == 1) {
            // И при этом всего одна макс. группа, то один символ из одной макс группы можно удалить по условию задачи
            if (maxCnt == 1) {
                return YES;
            }
            // И при этом если всего символов, занимаемых мин группой столько же, сколько и длина мин группы.
            // т.е. есть всего одна группа мин символов
            if (minLettersLength == min) {
                return YES;
            }
        }

        return NO;
    }

    public static void main(String[] args) {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";

        String valid = SherlockStrings.isValid(s);

        System.out.println(valid);
    }

}
