import methods.gauss
import methods.iterations
import methods.kramer
import java.util.*

fun main() {
    println("Kramer method: ")
    println(kramer().contentToString())
    println("------------")
    println("Gauss method: ")
    println(gauss().contentToString())
    println("------------")
    println("Iterations method: ")
    println(iterations().contentToString())
    println("------------")
}