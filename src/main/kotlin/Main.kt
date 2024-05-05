package org.example

import kotlinx.cli.*

fun main(args: Array<String>) {
    val parser = ArgParser("KotlinCLISearch")

    val name by parser.option(
        ArgType.String,
        shortName = "n",
        description = "User name"
    )

    parser.parse(args)

    println("Hello, $name!")
}
