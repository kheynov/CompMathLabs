package methods

import det
import replaceRow
import transpose

fun kramer(matrix: Array<Array<Int>>, b: Array<Int>): MutableList<Int> {
    val t = transpose(matrix)
    val d = det(matrix)
    if (d == 0) throw Error("No solution because determinant is 0")

    val result = mutableListOf<Int>()
    for (i in 0 until t.size) {
        result[i] = det(replaceRow(t, i, b)) / d
    }
    return result
}