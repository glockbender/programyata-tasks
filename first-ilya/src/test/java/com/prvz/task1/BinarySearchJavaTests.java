//package com.prvz.task1;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class BinarySearchJavaTests {
//
//    BinarySearchJava search = new BinarySearchJava();
//
//    int[] hundredElementsFromZeroAsc = new int[100];
//
//    {
//        for (int i = 0; i < hundredElementsFromZeroAsc.length; i++) {
//            hundredElementsFromZeroAsc[i] = i;
//        }
//    }
//
//    @Test
//    public void binarySearchShouldFoundAllElements() {
//
//        for (int i = 0; i < 100; i++) {
//            Assertions.assertTrue(search.search(hundredElementsFromZeroAsc, i));
//        }
//
//    }
//
//    @Test
//    public void binarySearchShouldNotFoundAllElements() {
//
//        for (int i = 100; i < 200; i++) {
//            Assertions.assertFalse(search.search(hundredElementsFromZeroAsc, i));
//        }
//    }
//
//}
