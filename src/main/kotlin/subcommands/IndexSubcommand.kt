package org.example.subcommands

class IndexSubcommand : CommonOptions("index", "Index a provided folder") {

    override fun execute() {
        println("Indexing files in directory: $path")
    }

}