package com.prvz.programyata.tasks.task4

import com.prvz.programyata.tasks.task4.graph.TreeGraph

fun main() {

    val graph = TreeGraph(11)
    graph.addNodeTo(21,11)
    graph.addNodeTo(22,11)
    graph.addNodeTo(23,11)
    graph.addNodeTo(31,21)
    graph.addNodeTo(32,21)
    graph.addNodeTo(33,22)
    graph.addNodeTo(34,22)
    graph.addNodeTo(41,34)
    graph.addNodeTo(33,41)

    graph.hasPath(11, 33)

}
