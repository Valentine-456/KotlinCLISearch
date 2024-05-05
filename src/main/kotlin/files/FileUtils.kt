package org.example.files

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object FileUtils {
    fun createDir(parentPath: String, newDirName: String): Path {
        val parentDir = Paths.get(parentPath)
        val newDir = parentDir.resolve(newDirName)
        if (!Files.exists(newDir)) {
            Files.createDirectory(newDir)
        }
        return newDir
    }
}