package org.example.index

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.StoredField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory
import org.example.files.FileUtils
import java.io.File
import java.io.FileReader
import java.nio.file.Files
import java.nio.file.Path


class Indexer(private val path: String) {
    fun index() {
        val dataDir = File(path)
        val indexDirPath = FileUtils.createIndexDirectory(path)

        val indexDir: Directory = FSDirectory.open(indexDirPath)
        val analyzer: Analyzer = StandardAnalyzer()
        val config: IndexWriterConfig = IndexWriterConfig(analyzer).apply {
            openMode = IndexWriterConfig.OpenMode.CREATE
        }
        val indexWriter = IndexWriter(indexDir, config)

        Files.walk(dataDir.toPath())
            .filter { path -> shouldIndex(path) }
            .forEach { path -> parseDocument(path.toFile(), indexWriter) }

        indexWriter.flush()
        indexWriter.close()
    }

    private fun shouldIndex(path: Path): Boolean {
        val file = path.toFile()
        return file.isFile &&
                FileUtils.INDEX_DIRECTORY_NAME !in path.toString()
    }

    private fun parseDocument(file: File, indexWriter: IndexWriter) {
        val doc: Document = Document()
        doc.add(StoredField("path", file.absolutePath.toString()))
        doc.add(TextField("content", FileReader(file)))
        indexWriter.addDocument(doc)
    }
}