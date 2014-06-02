package com.anosearch.index.anodoc;

import com.anosearch.index.AbstractIndexer;
import com.anosearch.index.indexConfig.IndexConfig;
import com.anosearch.index.Indexable;
import com.anosearch.index.indexConfig.IndexDocumentConfig;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

import java.io.IOException;

/**
 *  Implementation indexer Interface for AnoDoc.
 */
public class AnoDocIndexer extends AbstractIndexer {

    /**
     * Singleton
     */
    private static class InstanceHolder {
        private final static AnoDocIndexer instance = new AnoDocIndexer();
    }

    public static AnoDocIndexer getInstance(){
        return InstanceHolder.instance;
    }

    private AnoDocIndexer() {
        IndexConfig indexConfig = IndexDocumentConfig.getInstance();
        initIndexWriter(indexConfig.getIndexDirectory(), indexConfig.getIndexWriterConfig());
    }

    public void createIndex(net.anotheria.anodoc.data.Document document){
        AnoDocWrapper anoDocWrapper = new AnoDocWrapper(document);

        createIndex(anoDocWrapper);
    }

    @Override
    public void createIndex(Indexable indexableObj) {
        try {
            AnoDocWrapper docWrapper = (AnoDocWrapper) indexableObj;
            indexWriter.addDocument(docWrapper);

//            Document document = new Document();

//            for (Property prop : docWrapper.getDocument().getProperties()) {
//                addFieldToDocument(document, createTextField(prop.getId(), (String) prop.getValue(), true));
//            }

        } catch (IOException e){
            throw new RuntimeException("can't add document to IndexWriter", e);
        } finally {
            /// indexWriter should be closed.
        }
    }


    /**
     * Adds IndexableField to {@link org.apache.lucene.document.Document}
     * @param doc {@link org.apache.lucene.document.Document}
     * @param indexableField {@link org.apache.lucene.index.IndexableField}
     */
    public void addFieldToDocument(Document doc, IndexableField indexableField){
        doc.add(indexableField);
    }

    /**
     * Creates instance of TextField.
     * @param name name of filed.
     * @param value field value.
     * @param store flag that determines whether the field will be stored
     * @return TextField instance.
     */
    public TextField createTextField(String name, String value, boolean store){
        return new TextField(name, name, (store ? Field.Store.YES : Field.Store.NO) );
    }
}
