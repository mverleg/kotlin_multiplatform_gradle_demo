package demo.alpha

import demo.beta.Beta
import demo.gamma.Gamma

fun main(args: Array<String>) {
    Gamma().multiplatform()
    println("Hello from ${Beta().getPlatform()}")
}


