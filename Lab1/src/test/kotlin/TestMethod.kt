import kotlin.math.abs
import kotlin.system.measureTimeMillis

fun testMethod(
    label: String,
    method: (
        matrix: Array<Array<Double>>,
        b: Array<Double>
    ) -> Array<Double>,
    matrix: Array<Array<Double>>,
    values: Array<Double>,
    solution: Array<Double>,
    eps: Double
) {
    println("TESTING METHOD: $label")
    println("----------------------")
    println("Result: \n")
    val result: Array<Double>
    val elapsedTime = measureTimeMillis {
        result = method(matrix, values)
    }
    for (i in result.indices) {
        println("X$i= ${result[i]}")
    }
    println("\nTOTAL TIME: $elapsedTime milliseconds")
    var success = true
    result.forEach { success = abs(it - solution[result.indexOf(it)]) < eps }
    println("TEST PASSED: $success")
    println("======================")
}