package com.anosearch.index;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;

import java.io.Closeable;
import java.io.IOException;

/**
 * Partial implementation of Indexer interface
 */
public abstract class AbstractIndexer implements Indexer, Closeable{
    /**
     * IndexWriter instance which used to make index.
     */
    protected IndexWriter indexWriter;

    /**
     * Initialize indexWriter.
     * @param index {@link org.apache.lucene.store.Directory} which contains index.
     * @param config {@link org.apache.lucene.index.IndexWriterConfig} which contains config  for IndexWriter.
     */
    @Override
    public void initIndexWriter(Directory index, IndexWriterConfig config){
        try {
            if (indexWriter != null)
                indexWriter = new IndexWriter(index, config);
        } catch (IOException e){
            throw new RuntimeException("can't initialize IndexWriter", e);
        }
    }

    /**
     * Close indexWriter.
     */
    @Override
    public void closeIndexWriter(){
        try {
            indexWriter.close();
        } catch (IOException e){
            throw new RuntimeException("can't close IndexWriter", e);
        }
    }

    @Override
    public void close(){
        closeIndexWriter();
    }
}
