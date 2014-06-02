package com.anosearch.index.indexConfig;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.configureme.ConfigurationManager;
import org.configureme.environments.DynamicEnvironment;

/**
 * Created by admin on 5/30/14.
 */
public class IndexParametersConfig extends IndexConfig {
    private IndexParametersConfig() {
        ConfigurationManager.INSTANCE.configure(this, new DynamicEnvironment("param-index"));

        analyzer = new StandardAnalyzer(version);
        indexWriterConfig = new IndexWriterConfig(version, analyzer);
        indexDirectory = getSimpleFSDirectory(FILE_PATH);
    }

    /**
     * Singleton
     */
    private static class InstanceHolder{
        private final static IndexParametersConfig instance = new IndexParametersConfig();
    }

    /**
     * IndexConfig factory.
     * @return instance of the IndexConfig.
     */
    public static IndexConfig getInstance(){
        return InstanceHolder.instance;
    }
}


