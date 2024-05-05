package org.example.subcommands

import kotlinx.cli.ArgType
import kotlinx.cli.required

class SearchSubcommand: CommonOptions("search", "Search in a provided folder") {
    val queryToSearch by option(
        ArgType.String,
        shortName = "q",
        fullName = "query",
        description = "Query to search for in files of a chosen folder"
    ).required()

    override fun execute() {
        println("Search for query='$queryToSearch' in folder=$path")
    }

}