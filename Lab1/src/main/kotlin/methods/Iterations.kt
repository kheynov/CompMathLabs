package methods

import InitialData
import kotlin.math.abs

fun iterations(matrix: Array<Array<Int>>, b: Array<Int>): Array<Int> {
    val n = matrix.size
    for (i in 0 until n) {
        if (matrix[i][i] == 0) throw Error("Diagonal coefficients must not be equal to 0")
    }

    for (i in 0 until n) {
        var sum = 0
        for (j in 0 until n) {
            sum += if (i == j) 0 else abs(matrix[i][j])
        }
        if (abs(matrix[i][i]) <= sum) throw Error("Diagonal dominance is not fulfilled in the provided matrix")
    }

    val beta = b.clone()
    for (i in 0 until n) {
        beta[i] /= matrix[i][i]
    }

    val alpha = matrix.clone()
    for (i in 0 until n) {
        for (j in 0 until n) {
            alpha[i][j] = if (i == j) 0 else -alpha[i][j] / matrix[i][i]
        }
    }

    var xs = beta.clone()
    var iterations = 0
    while (true) {
        iterations++
        val result = beta.clone()
        for (i in 0 until n) {
            var sum = 0
            for (j in 0 until n) {
                sum += alpha[i][j] * xs[j]
            }
            result[i] += sum
        }

        var continueLoop = false
        for (i in 0 until n) {
            if (abs(result[i] - xs[i]) >= InitialData.eps) {
                xs = result
                continueLoop = true
                break
            }
        }
        if (!continueLoop) {
            println("Iterations: $iterations")
            return result
        }
    }
}