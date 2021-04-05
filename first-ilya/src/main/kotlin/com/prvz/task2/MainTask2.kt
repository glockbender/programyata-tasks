//@file:Suppress("MagicNumber")
//
//package com.prvz.task2
//
//fun main() {
//
//    val list = CustomMutableLinkedList<Int>()
//
//    for (i in 0..10) {
//        list.add(i)
//    }
//
//    // 0,1,2,3,4,5,6,7,8,9,10 - 12 elements
//
//    list.remove(10)
//
//    assert(list.size == 11)
//
//    // 0,1,2,3,4,5,6,7,8,9 - 11 elements
//
//    list.addFirst(-1)
//
//    list.iterator().forEach { print("$it, ") }
//
//    // -1,0,1,2,3,4,5,6,7,8,9 - 12 elements
//
//    for (i in -1..9) {
//        assert(list.contains(i))
//        list.remove(i)
//    }
//
//    assert(list.isEmpty())
//
//    println("Success")
//}
