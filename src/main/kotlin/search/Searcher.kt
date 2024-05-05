package org.example.search

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.search.*
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.util.QueryBuilder
import org.example.files.FileUtils


class Searcher(private val queryStr: String, private val path: String) {
    private val searcher: IndexSearcher
    init {
        val indexDir= FileUtils.resolveIndexDirectory(path)
        val directory: Directory = FSDirectory.open(indexDir)
        val indexReader: IndexReader = DirectoryReader.open(directory)
        searcher = IndexSearcher(indexReader)
    }

    fun runQuery() {
        val analyzer: Analyzer = StandardAnalyzer()
        val builder: QueryBuilder = QueryBuilder(analyzer)

        val query: Query = builder.createPhraseQuery("content", queryStr)

        val topDocs = searcher.search(query, 100)

        val hits = topDocs.scoreDocs

        for (i in hits.indices) {
            val docId = hits[i].doc
            val d: Document = searcher.doc(docId)
            println(d.get("path") + " Score :" + hits[i].score)
        }

        println("Found " + hits.size)

    }

}