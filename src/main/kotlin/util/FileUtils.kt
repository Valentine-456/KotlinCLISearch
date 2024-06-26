package org.example.files

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object FileUtils {
    const val INDEX_DIRECTORY_NAME = ".indexKotlinSearchCLI"

    fun createIndexDirectory(parentPath: String): Path {
        val newDir = resolveIndexDirectory(parentPath)
        if (!Files.exists(newDir)) {
            Files.createDirectory(newDir)
        }
        return newDir
    }

    fun resolveIndexDirectory(parentPath: String): Path {
        val parentDir = Paths.get(parentPath)
        return parentDir.resolve(INDEX_DIRECTORY_NAME)
    }
}