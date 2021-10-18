import methods.gauss
import methods.iterations
import methods.kramer

fun main() {
    println("Kramer method: ")
    println(kramer(InitialData.matrix, InitialData.b).contentToString())
    println("------------")
    println("Gauss method: ")
    println(gauss(InitialData.matrix, InitialData.b).contentToString())
    println("------------")
    println("Iterations method: ")
    println(iterations(InitialData.matrix, InitialData.b).contentToString())
    println("------------")
}