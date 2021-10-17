import kotlin.math.pow

fun minor(
    matrix: Array<Array<Int>>,
    row: Int,
    column: Int
): Array<Array<Int>> {
    val newMatrix = mutableListOf<MutableList<Int>>()
    for (i in matrix.indices) {
        if (i == row) continue
        val newRow = mutableListOf<Int>()
        for (j in matrix[i].indices) {
            if (j == column) continue
            newRow.add(matrix[i][j])
        }
        newMatrix.add(newRow)
    }

    return newMatrix.mutableMatrixToArray()
}

private fun MutableList<MutableList<Int>>.mutableMatrixToArray(): Array<Array<Int>> {
    val newArrayMatrix = Array(this.size) { Array(this.size) { 0 } }
    for (i in this.indices) {
        for (j in this[i].indices) {
            newArrayMatrix[i][j] = this[i][j]
        }
    }
    return newArrayMatrix
}

fun det(
    matrix: Array<Array<Int>>
): Int {
    if (matrix.size == 1 && matrix[0].size == 1) return matrix[0][0]
    var result = 0.0
    for (i in matrix.indices) {
        result += (-1.0).pow((1.0 + i)) * matrix[0][i] * det(minor(matrix, 0, i))
    }
    return result.toInt()
}

fun transpose(
    matrix: Array<Array<Int>>
): MutableList<MutableList<Int>> {
    val newMatrix = mutableListOf<MutableList<Int>>()
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            newMatrix[j][i] = matrix[i][j]
        }
    }
    return newMatrix
}

fun replaceRow(
    matrix: MutableList<MutableList<Int>>,
    rowIndex: Int,
    row: Array<Int>
): Array<Array<Int>> {
    val newMatrix = mutableListOf<MutableList<Int>>()
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