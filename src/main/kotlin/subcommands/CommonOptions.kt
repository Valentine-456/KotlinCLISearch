package org.example.subcommands

import kotlinx.cli.ArgType
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import kotlinx.cli.default
import java.nio.file.Paths

@OptIn(ExperimentalCli::class)
abstract class CommonOptions(name: String, actionDescription: String) : Subcommand(name, actionDescription) {
    private val cwd = Paths.get("").toAbsolutePath()
    val path by option(
        ArgType.String,
        shortName = "p",
        fullName = "path",
        description = "Folder to index/search"
    ).default(cwd.toString())
}
