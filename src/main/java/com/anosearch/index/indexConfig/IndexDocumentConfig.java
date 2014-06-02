package com.anosearch.index.indexConfig;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.configureme.ConfigurationManager;
import org.configureme.environments.DynamicEnvironment;

/**
 * Created by admin on 5/30/14.
 */
public class IndexDocumentConfig extends IndexConfig {
    private IndexDocumentConfig() {
        ConfigurationManager.INSTANCE.configure(this, new DynamicEnvironment("doc-index"));

        analyzer = new StandardAnalyzer(version);
        indexWriterConfig = new IndexWriterConfig(version, analyzer);
        indexDirectory = getSimpleFSDirectory(FILE_PATH);
    }


    /**
     * Singleton
     */
    private static class InstanceHolder{
        private final static IndexDocumentConfig instance = new IndexDocumentConfig();
    }

    /**
     * IndexConfig factory.
     * @return instance of the IndexConfig.
     */
    public static IndexConfig getInstance(){
        return InstanceHolder.instance;
    }
}
