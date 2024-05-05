package org.example.subcommands

import kotlinx.cli.ArgType
import kotlinx.cli.required
import org.example.files.FileUtils
import org.example.search.Searcher
import org.example.util.Timer

class SearchSubcommand : CommonOptions("search", "Search in a provided folder") {
    val queryToSearch by option(
        ArgType.String,
        shortName = "q",
        fullName = "query",
        description = "Query to search for in files of a chosen folder"
    ).required()

    override fun execute() {
        Timer.start()
        println("Search for query='$queryToSearch' in folder=$path")
        val searcher: Searcher
        try {
            searcher = Searcher(queryToSearch, path)
        } catch (exception: IllegalStateException) {
            println("Fatal: not an indexed folder: ${FileUtils.INDEX_DIRECTORY_NAME}")
            return
        }
        searcher.runQuery()
        Timer.stopAndPrint("Search of a query")
    }

}