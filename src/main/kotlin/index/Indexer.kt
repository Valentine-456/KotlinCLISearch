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


class Indexer(private val path: String) {
     public fun index() {
         val dataDir = File(path)
         val indexDirPath = FileUtils.createIndexDirectory(path)

         val indexDir: Directory = FSDirectory.open(indexDirPath)
         val analyzer: Analyzer = StandardAnalyzer()
         val config: IndexWriterConfig = IndexWriterConfig(analyzer)
         val indexWriter = IndexWriter(indexDir, config)

         dataDir.listFiles()?.iterator()?.forEach {
             if (it.isFile) {
                 parseDocument(it, indexWriter)
             }
         }
         indexWriter.flush()
         indexWriter.close()
     }

    private fun parseDocument(file: File, indexWriter: IndexWriter) {
        val doc: Document = Document()
        doc.add(StoredField("path", file.absolutePath.toString()))
        doc.add(TextField("content", FileReader(file)))
        indexWriter.addDocument(doc)
    }
}