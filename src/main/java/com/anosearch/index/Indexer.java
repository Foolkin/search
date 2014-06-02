package com.anosearch.index;

import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;

import java.io.IOException;

/**
 * Interface for Indexing data.
 * Implementation should contains method that initialize IndexWriter,
 * method which close that IndexWriter and method which indexes data.
 */
public interface Indexer {

    /**
     * Initialize IndexWriter.
     *
     * @param index {@link org.apache.lucene.store.Directory} which contains index.
     * @param config {@link org.apache.lucene.index.IndexWriterConfig} which contains config  for IndexWriter.
     */
    public void initIndexWriter(Directory index, IndexWriterConfig config);

    /**
     * Make index for indexable object.
     * @param indexableObj Indexable object.
     */
    public void createIndex(Indexable indexableObj);

    /**
     * Close IndexWriter.
     */
    public void closeIndexWriter() throws IOException;
}
