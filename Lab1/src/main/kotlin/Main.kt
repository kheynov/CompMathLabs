import methods.gauss
import methods.iterations
import methods.kramer
import java.util.*

fun main() {
    println("Kramer method: ")
    println(kramer())
    println("------------")
    println(gauss().contentToString())
    println("------------")
    println("Iterations method: ")
    println(iterations())
    println("------------")
}