@file:Suppress("TooManyFunctions")

package com.prvz.task2

class CustomMutableLinkedList<T> : MutableIterable<T>, MutableCollection<T> {

    private var sizeIn: Int = 0

    override val size: Int
        get() = sizeIn

    private var init = false

    @Suppress("LateinitUsage")
    private lateinit var first: Bucket<T>

    @Suppress("LateinitUsage")
    private lateinit var last: Bucket<T>

    override fun iterator(): MutableIterator<T> = if (init) {
        LinkedListIterator(first)
    } else {
        EMPTY_ITERATOR
    }

    fun addFirst(element: T): Boolean =
        if (init) {
            first = insertAsBucketBefore(element, first)
            sizeIn++
            true
        } else {
            init(element)
        }

    fun addLast(element: T): Boolean =
        if (init) {
            last = insertAsBucketAfter(element, last)
            sizeIn++
            true
        } else {
            init(element)
        }

    override fun contains(element: T): Boolean {
        iterator().forEach {
            if (element?.equals(it) == true) {
                return true
            }
        }
        return false
    }

    @Suppress("ForbiddenComment")
    // fixme: некорректное поведение, для списков с повоторяющимися значениями
    override fun containsAll(elements: Collection<T>): Boolean {
        var found = 0
        iterator().forEach { if (elements.contains(it)) found++ }
        return found == elements.size
    }

    override fun isEmpty(): Boolean = size == 0

    override fun add(element: T): Boolean = addLast(element)

    override fun addAll(elements: Collection<T>): Boolean {
        elements.onEach { addLast(it) }
        return true
    }

    override fun clear() {
        val iter = iterator()
        iter.forEachRemaining { iterator().remove() }
    }

    override fun remove(element: T): Boolean {
        val iter = iterator()
        while (iter.hasNext()) {
            val next = iter.next()
            if (next?.equals(element) == true) {
                iter.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean =
        elements.map { remove(it) }.any { it }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    private fun insertAsBucketBefore(element: T, beforeBucket: Bucket<T>): Bucket<T> {

        val newBucket = Bucket(
            left = beforeBucket.left,
            right = beforeBucket,
            element = element
        )

        beforeBucket.left?.right = newBucket

        beforeBucket.left = newBucket

        return newBucket
    }

    private fun insertAsBucketAfter(element: T, afterBucket: Bucket<T>): Bucket<T> {

        val newBucket = Bucket(
            left = afterBucket,
            right = afterBucket.right,
            element = element
        )

        afterBucket.right?.left = newBucket

        afterBucket.right = newBucket

        return newBucket
    }

    private fun <T> removeBucket(bucket: Bucket<T>) {

        if (bucket.left != null) {
            bucket.left!!.right = bucket.right
        }

        if (bucket.right != null) {
            bucket.right!!.left = bucket.left
        }

        bucket.destroy()
    }

    private fun init(element: T): Boolean {
        first = Bucket(
            left = null,
            right = null,
            element = element
        )
        last = first
        sizeIn = 1
        init = true
        return true
    }

    inner class Bucket<T>(
        var left: Bucket<T>?,
        var right: Bucket<T>?,
        element: T
    ) {
        private var element: T? = element

        fun element(): T = element ?: throw IllegalStateException("Bucket was destroyed")

        fun destroy() {
            left = null
            right = null
            element = null
        }
    }

    inner class LinkedListIterator(from: Bucket<T>) : MutableIterator<T> {

        private var currentBucket: Bucket<T>? = null
        private var nextBucket: Bucket<T>? = from

        override fun hasNext(): Boolean = nextBucket != null

        override fun next(): T {

            if (!hasNext()) {
                throw NoSuchElementException()
            }

            currentBucket = nextBucket!!
            nextBucket = nextBucket?.right

            return currentBucket!!.element()
        }

        override fun remove() {
            if (currentBucket == null) {
                throw IllegalStateException("There's no selected item")
            }
            removeBucket(currentBucket!!)
            currentBucket = null
        }
    }

    companion object {
        val EMPTY_ITERATOR = object : MutableIterator<Nothing> {
            override fun hasNext(): Boolean = false

            override fun next(): Nothing = throw NoSuchElementException()

            @Suppress("EmptyFunctionBlock")
            override fun remove() {
            }
        }
    }
}
