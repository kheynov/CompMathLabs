package methods

import det
import replaceRow
import transpose

fun kramer(
    matrix: Array<Array<Double>>,
    b: Array<Double>
): Array<Double> {
    val t = transpose(matrix)
    val d = det(matrix)
    if (d == 0.0) throw Error("No solution because determinant is 0")

    val result = mutableListOf<Double>()
    for (i in 0 until t.size) {
        result.add(det(replaceRow(t, i, b)) / d)
    }
    return result.toTypedArray()
}