package org.example

import kotlinx.cli.*

fun main(args: Array<String>) {
    val parser = ArgParser("example")

    val name by parser.option(
        ArgType.String,
        shortName = "n",
        description = "User name"
    )

    parser.parse(args)

    println("Hello, $name!")
}
