package methods

fun gauss(
    matrix: Array<Array<Double>>,
    b: Array<Double>
): Array<Double> {
    val n = b.size
    val extended = Array(matrix.size) { Array(matrix.size + 1) { 0.0 } }//creating an extended matrix of a solution

    for (i in matrix.indices) { //copy a matrix of equation to an extended matrix
        for (j in matrix[0].indices) {
            extended[i][j] = matrix[i][j]
        }
    }

    for (i in 0 until n) {//adding b values to an extended matrix
        extended[i][n] = b[i]
    }

    for (i in 0 until n) {
        val firstElement = extended[i][i]
        for (j in 0 until n + 1) {
            extended[i][j] /= firstElement
        }

        for (k in i + 1 until n) {
            val coefficient = extended[k][i] / extended[i][i]
            for (j in 0 until n + 1) {
                extended[k][j] -= (extended[i][j] * coefficient)
            }
        }
    }




    val result = arrayOfNulls<Double>(n)
    for (i in n - 1 downTo 0) {
        val value = extended[i][n]
        var sum = 0.0
        for (j in 0 until n) {
            sum += if (result[j] == null) 0.0 else extended[i][j] * result[j]!!
        }
        result[i] = (value - sum) / extended[i][i]
    }
    return result.requireNoNulls()
}