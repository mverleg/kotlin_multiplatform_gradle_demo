package demo.alpha

import demo.beta.getPlatform
import demo.gamma.multiplatform

fun main(args: Array<String>) {
    multiplatform()
    println("Hello from ${getPlatform()}")
}


