package com.anosearch.index.anodoc;

import com.anosearch.index.indexConfig.IndexConfig;
import com.anosearch.index.indexConfig.IndexDocumentConfig;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;

import java.io.IOException;

/**
 * Created by admin on 5/20/14.
 */
public class AnoDocIndexSearcher {
    private AnoDocIndexSearcher() {
        throw new AssertionError("Shouldn't be initiated");
    }

    public static Document[] search(Query query, int hitsPerPage) throws IOException {
        IndexConfig indexConfig = IndexDocumentConfig.getInstance();
        IndexReader reader = DirectoryReader.open(indexConfig.getIndexDirectory());
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);

        searcher.search(query, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;
        Document[] docs = new Document[hits.length];

        for(int i = 0; i < hits.length; i++ ){
            int docId = hits[i].doc;
            docs[i] = searcher.doc(docId);
        }
        reader.close();
        return docs;
    }
}
