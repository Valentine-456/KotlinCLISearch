package org.example.subcommands

import org.example.index.Indexer
import org.example.util.Timer

class IndexSubcommand : CommonOptions("index", "Index a provided folder") {

    override fun execute() {
        Timer.start()
        println("Indexing files in directory: $path")
        val indexer = Indexer(path)
        indexer.index()
        Timer.stopAndPrint("Indexing operation")
    }

}