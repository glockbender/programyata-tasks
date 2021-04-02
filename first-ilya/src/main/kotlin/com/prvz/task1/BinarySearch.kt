@file:Suppress("MagicNumber")

package com.prvz.task1

class BinarySearch {

    /**
     * Выполняет бинарный поиск.
     * @param arr - ОТСОРТИРОВАННЫЙ челочисленный массив, в котором необходимо найти число
     * @param find - Искомое число
     * @return Индекс найденного элемента, или [-1] если элемент не найден
     */
    fun search(arr: IntArray, find: Int): Int {

        var from = 0
        var to = arr.size - 1

        while (from <= to) {

            val midIdx = (to + (to - from)) / 2
            val midVal = arr[midIdx]

            when {
                midVal > find -> to = midIdx - 1
                midVal < find -> from = midIdx + 1
                else -> return midIdx
            }
        }

        return -1
    }

    /**
     * Рекурсивно выполняет бинарный поиск.
     * @param arr - ОТСОРТИРОВАННЫЙ челочисленный массив, в котором необходимо найти число
     * @param find - Искомое число
     * @return true, если элемент найден. Иначе false
     */
    fun searchRecursive(arr: IntArray, find: Int): Boolean {

        if (arr.size == 1) {
            val value = arr[0]
            return find == value
        } else {
            val midIdx = (arr.size - 1) / 2
            val midVal = arr[midIdx]
            val newArray = when {
                midVal < find -> arr.copyOfRange(midIdx + 1, arr.size)
                midVal > find -> arr.copyOfRange(0, midIdx)
                else -> return true
            }
            return searchRecursive(newArray, find)
        }
    }
}

@Suppress("LongMethod", "ReturnCount")
fun main() {

    // Testing
    BinarySearch().run {
        val arr1 = intArrayOf(1, 2, 3)
        val arr2 = intArrayOf(1, 2, 3, 4, 5, 6)
        val arr3 = (0..1000000).toMutableList().toIntArray()

        println(search(arr1, 1))
        println(search(arr2, 1))
        println(search(arr3, 100000))

        println(searchRecursive(arr1, 1))
        println(searchRecursive(arr2, 1))
        println(searchRecursive(arr3, 100000))
    }

    println("Enter a sorted array to search and press \"Enter\" key.\nNote numbers must be divided by ','")
    val arrIn = readLine()?.split(',')
    if (arrIn == null) {
        System.err.println("Input problems")
        return
    }
    if (arrIn.isEmpty()) {
        System.err.println("No data entered")
        return
    }
    val arr = try {
        arrIn.map(String::toInt).toIntArray()
    } catch (nfe: NumberFormatException) {
        System.err.println("Found illegal character")
        return
    }

    println("Enter the desired number and press \"Enter\" key")
    val findIn = readLine()
    if (findIn == null) {
        System.err.println("Input problems")
        return
    }
    if (findIn.isBlank()) {
        System.err.println("No data entered")
        return
    }
    val find = try {
        findIn.toInt()
    } catch (nfe: NumberFormatException) {
        System.err.println("Found illegal character")
        return
    }

    println(BinarySearch().search(arr = arr, find = find))
}
