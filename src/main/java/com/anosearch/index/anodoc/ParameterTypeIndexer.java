package com.anosearch.index.anodoc;

import com.anosearch.index.AbstractIndexer;
import com.anosearch.index.Indexable;
import com.anosearch.index.indexConfig.IndexConfig;
import com.anosearch.index.indexConfig.IndexParametersConfig;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 5/23/14.
 */
public class ParameterTypeIndexer extends AbstractIndexer {

    Set<String> paramNames = new HashSet<String>();

    /**
     * Singleton
     */
    private static class InstanceHolder {
        private final static ParameterTypeIndexer instance = new ParameterTypeIndexer();
    }

    public static ParameterTypeIndexer getInstance(){
        return InstanceHolder.instance;
    }

    public ParameterTypeIndexer() {
        IndexConfig indexConfig = IndexParametersConfig.getInstance();
        initIndexWriter(indexConfig.getIndexDirectory(), indexConfig.getIndexWriterConfig());
    }

    @Override
    public void createIndex(Indexable indexableObj) {
        try {
            if (paramNames.isEmpty())
                paramNames.addAll(loadAllExistParams());
            /*
            Index object if it's not been in paramNames, and add to paramNames
             */

            AnoDocWrapper anoDoc = (AnoDocWrapper) indexableObj;


        } catch (IOException e){
            e.printStackTrace();////
        }
    }

    public List<String> loadAllExistParams() throws IOException{
        try {
            List<String> paramNames = new ArrayList<String>();
            IndexReader reader = DirectoryReader.open(IndexParametersConfig.getInstance().getIndexDirectory());
            for (int i = 0; i < reader.numDocs(); i++) {
                Document doc = reader.document(i);
                paramNames.add(doc.get("name"));
            }
            return paramNames;
        } finally {
            //close the directory
        }
    }


}
