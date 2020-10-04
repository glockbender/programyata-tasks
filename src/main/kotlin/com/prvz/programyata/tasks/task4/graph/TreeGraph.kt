package com.prvz.programyata.tasks.task4.graph

import java.util.LinkedList
import java.util.Queue
import java.util.concurrent.ConcurrentHashMap

/**
 * Supports only one root element. Elements cannot be looped by itself.
 */
class TreeGraph<T> constructor(
    rootValue: T
) : Graph<T> {

    private val connections: MutableMap<T, MutableSet<T>> =
        ConcurrentHashMap<T, MutableSet<T>>()
            .apply { put(rootValue, mutableSetOf()) }

    override fun addNodeTo(newValue: T, toValue: T) {

        connections.computeIfPresent(toValue) { keyNode, edges ->
            if (keyNode == newValue) {
                throw IllegalArgumentException("Values are equals")
            }
            val result = if (edges.isEmpty()) {
                mutableSetOf(newValue)
            } else {
                if (edges.contains(newValue)) {
                    throw IllegalStateException("Value: $newValue always related to $toValue")
                } else {
                    edges.add(newValue)
                    edges
                }
            }
            connections[newValue] = mutableSetOf()
            return@computeIfPresent result
        }
            ?: throw IllegalArgumentException("There's no value registered. Value: $toValue")
    }

    override fun hasValue(value: T): Boolean = connections.containsKey(value)

    override fun listValue(): List<T> = connections.keys.toList()

    override fun hasPath(from: T, to: T): Boolean {
        if (!connections.containsKey(from)) {
            throw IllegalArgumentException("'From' node was not registered")
        }
        if (from == to) {
            return true
        }
        if (!connections.containsKey(to)) {
            throw IllegalArgumentException("'To' node was not registered")
        }

        val searchQueue: Queue<T> = LinkedList(connections[from]!!)

        val alreadyVisited: MutableSet<T> = mutableSetOf(from)

        try {
            while (searchQueue.isNotEmpty()) {
                val node = searchQueue.poll()
                println("Walk node: $node")
                if (node == to) {
                    println("Node found!")
                    return true
                }
                val related = connections[node]!!
                searchQueue.addAll(related)
                alreadyVisited.add(node)
                println("Node wasn't found yet!")
            }
            return false
        } finally {
            searchQueue.clear()
            alreadyVisited.clear()
        }
    }
}
