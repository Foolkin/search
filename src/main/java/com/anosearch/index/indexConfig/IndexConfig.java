package com.anosearch.index.indexConfig;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.configureme.annotations.Configure;
import org.configureme.annotations.ConfigureMe;

import java.io.File;
import java.io.IOException;

/**
 * Configure class which contains settings for indexing and searching index.
 */
@ConfigureMe (name = "index-storage")
public abstract class IndexConfig {
    /**
     * Directory where will stored file index file.
     */
    @Configure
    protected String FILE_PATH;

    /**
     * String value of lucene version.
     */
    @Configure
    protected String LUCENE_VERSION;

    /**
     * {@link org.apache.lucene.util.Version}
     * Lucene version.
     */
    protected Version version;

    /**
     * {@link org.apache.lucene.store.Directory}
     * Directory were will be stored indexes.
     */
    protected Directory indexDirectory;

    /**
     * {@link org.apache.lucene.index.IndexWriterConfig}
     * Configuration for IndexWriter.
     */
    protected IndexWriterConfig indexWriterConfig;

    /**
     * {@link org.apache.lucene.analysis.Analyzer}
     * Text analyzer.
     */
    protected Analyzer analyzer;

    protected IndexConfig(){
        version = Version.parseLeniently(LUCENE_VERSION);
    }

    public Version getVersion() {
        return version;
    }

    public Directory getIndexDirectory() {
        return indexDirectory;
    }

    public void setIndexDirectory(Directory directory){
        this.indexDirectory = directory;
    }

    public IndexWriterConfig getIndexWriterConfig() {
        return indexWriterConfig;
    }

    public void setIndexWriterConfig(IndexWriterConfig indexWriterConfig){
        this.indexWriterConfig = indexWriterConfig;
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer){
        this.analyzer = analyzer;
    }

    ///////////?????????????????????????????
    public void closeIndexDirectory(){
        try {
            indexDirectory.close();
        } catch (IOException e){
            throw new RuntimeException("can't close indexDirectory", e);
        }
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public void setFILE_PATH(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public String getLUCENE_VERSION() {
        return LUCENE_VERSION;
    }

    public void setLUCENE_VERSION(String LUCENE_VERSION) {
        this.LUCENE_VERSION = LUCENE_VERSION;
    }

    protected RAMDirectory getRAMDirectory(){
        return new RAMDirectory();
    }

    protected SimpleFSDirectory getSimpleFSDirectory(String filePath){
        try {
            return new SimpleFSDirectory(new File(filePath));
        } catch (IOException e){
            throw new RuntimeException("can't create instance of SimpleFSDirectory", e);
        }
    }
}
