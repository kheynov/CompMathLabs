import methods.gauss
import methods.iterations
import methods.kramer

fun main() {
    val solution = arrayOf(
        -0.00485,
        0.08213,
        0.04069,
        0.04070
    )
    testMethod(
        "GAUSS",
        ::gauss,
        matrix = InitialData.matrix,
        values = InitialData.b,
        solution = solution,
        eps = InitialData.eps
    )
    testMethod(
        "Iterations",
        ::iterations,
        matrix = InitialData.matrix,
        values = InitialData.b,
        solution = solution,
        eps = InitialData.eps
    )
    testMethod(
        "Kramer",
        ::kramer,
        matrix = InitialData.matrix,
        values = InitialData.b,
        solution = solution,
        eps = InitialData.eps
    )
}

