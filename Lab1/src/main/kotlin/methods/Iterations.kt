package methods

import InitialData
import InitialData.matrix
import kotlin.math.abs

fun iterations(
    matrix: Array<Array<Double>>,
    b: Array<Double>
): Array<Double> {
    val n = matrix.size
    for (i in 0 until n) {
        if (matrix[i][i] == 0.0) throw Error("Diagonal coefficients must not be equal to 0")
    }

    for (i in 0 until n) {
        var sum = 0.0
        for (j in 0 until n) {
            sum += if (i == j) 0.0 else abs(matrix[i][j])
        }
        if (abs(matrix[i][i]) <= sum) throw Error("Diagonal dominance is not fulfilled in the provided matrix")
    }

    val result = mutableListOf(0.0, 0.0, 0.0, 0.0)
    val nextX = mutableListOf(0.0, 0.0, 0.0, 0.0)

    do {
        for (i in matrix.indices) {
            result[i] = nextX[i]
        }
        for (i in matrix.indices) {
            val beta = (b[i] / matrix[i][i])
            var temp = 0.0
            for (j in 0 until matrix[i].size) {
                var newA = 0.0
                if (i != j) {
                    newA = -(matrix[i][j] / matrix[i][i])
                }
                temp += result[j] * newA
            }
            nextX[i] = beta + temp
        }
    } while (validateEpsilon(
            x = result,
            nextX = nextX
        )
    )
    return result.toTypedArray()
}
fun validateEpsilon(x: MutableList<Double>, nextX: MutableList<Double>): Boolean {
    var iter = 0
    for (i in x.indices) {
        if (abs(x[i] - nextX[i]) >= InitialData.eps) {
            return true
        }
        iter++
    }
    return iter != matrix.size
}