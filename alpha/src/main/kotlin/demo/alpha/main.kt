package demo.alpha

import demo.beta.getPlatform
import demo.gamma.multiplatform

fun main(args: Array<String>) {
    println("Hello from ${getPlatform()} (also, ${multiplatform()})")
}


