package demo

import demo.common.getPlatform
import demo.other.tryThis

public fun main(args: Array<String>) {
    tryThis()
    println("Hello from ${getPlatform()}")
}

