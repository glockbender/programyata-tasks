//package com.prvz.task1;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class RuslanBinarySearchJavaTests2 {
//
//    @Test
//    public void test() {
//
//        BinarySearchJava bsj = new BinarySearchJava();
//
//        int[] arr = new int[]{1, 3, 5, 7, 9};
//
//        int findTrue = 3;
//
//        int findFalse = 2;
//
//        boolean mustBeTrue = bsj.search(arr, findTrue);
//
//        boolean mustBeFalse = bsj.search(arr, findFalse);
//
//        Assertions.assertTrue(mustBeTrue);
//
//        Assertions.assertFalse(mustBeFalse);
//
//        findTrue = 9;
//
//        findFalse = 10;
//
//        mustBeTrue = bsj.search(arr, findTrue);
//
//        mustBeFalse = bsj.search(arr, findFalse);
//
//        Assertions.assertTrue(mustBeTrue);
//
//        Assertions.assertFalse(mustBeFalse);
//
//    }
//}
