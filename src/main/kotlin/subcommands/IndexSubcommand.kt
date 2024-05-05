package org.example.subcommands

import org.example.index.Indexer

class IndexSubcommand : CommonOptions("index", "Index a provided folder") {

    override fun execute() {
        println("Indexing files in directory: $path")
        val indexer = Indexer(path)
        indexer.index()
    }

}