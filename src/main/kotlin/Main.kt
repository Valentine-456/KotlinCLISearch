package org.example

import kotlinx.cli.*
import org.example.subcommands.IndexSubcommand
import org.example.subcommands.SearchSubcommand


@OptIn(ExperimentalCli::class)
fun main(args: Array<String>) {
    val parser = ArgParser("KotlinCLISearch")

    parser.subcommands(IndexSubcommand(), SearchSubcommand())
    parser.parse(args)

}
