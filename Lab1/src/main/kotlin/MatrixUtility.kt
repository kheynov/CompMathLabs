import kotlin.math.pow

fun minor(
    matrix: Array<Array<Double>>,
    row: Int,
    column: Int
): Array<Array<Double>> {
    val newMatrix = mutableListOf<MutableList<Double>>()
    for (i in matrix.indices) {
        if (i == row) continue
        val newRow = mutableListOf<Double>()
        for (j in matrix[i].indices) {
            if (j == column) continue
            newRow.add(matrix[i][j])
        }
        newMatrix.add(newRow)
    }
    return newMatrix.mutableMatrixToArray()
}

private fun MutableList<MutableList<Double>>.mutableMatrixToArray(): Array<Array<Double>> {
//Extendable function to make simple array from mutable matrix
    val newArrayMatrix = Array(this.size) { Array(this.size) { 0.0 } }
    for (i in this.indices) {
        for (j in this[i].indices) {
            newArrayMatrix[i][j] = this[i][j]
        }
    }
    return newArrayMatrix
}

fun det(//calculating determinant of a matrix
    matrix: Array<Array<Double>>
): Double {
    if (matrix.size == 1 && matrix[0].size == 1) return matrix[0][0]
    var result = 0.0
    for (i in 0 until matrix[0].size) {
        result += (-1.0).pow((1.0 + i)) * matrix[0][i] * det(minor(matrix, 0, i))
    }
    return result
}

fun transpose(//transposing a matrix
    matrix: Array<Array<Double>>
): MutableList<MutableList<Double>> {
    val newMatrix = MutableList(matrix.size) { MutableList(matrix[0].size) { 0.0 } }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            newMatrix[j][i] = matrix[i][j]
        }
    }
    return newMatrix
}

fun replaceRow(//replace a row in a matrix to an another row
    matrix: MutableList<MutableList<Double>>,
    rowIndex: Int,
    row: Array<Double>
): Array<Array<Double>> {
    val newMatrix = MutableList(matrix.size) { MutableList(matrix[0].size) { 0.0 } }
    for (i in matrix.indices) {
        if (i == rowIndex) newMatrix[i] = row.toMutableList()
        else {
            for (j in matrix[i].indices) {
                newMatrix[i][j] = matrix[i][j]
            }
        }
    }
    return newMatrix.mutableMatrixToArray()
}