package demo

import demo.common.getPlatform
import try_this

public fun main(args: Array<String>) {
    try_this()
    println("Hello from ${getPlatform()}")
}

