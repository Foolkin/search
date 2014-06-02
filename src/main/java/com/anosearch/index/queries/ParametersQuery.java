package com.anosearch.index.queries;

import com.anosearch.index.anodoc.ConfigProperties;
import com.anosearch.index.indexConfig.IndexConfig;
import com.anosearch.index.indexConfig.IndexParametersConfig;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 6/2/14.
 */
public class ParametersQuery {
/*
    Если использовать configureme
    private static final ConfigProperties CONFIG_PROPERTIES = ConfigProperties.getInstance();
    */

    /**
     * Returns query for all indexed properties.
     * @param querystr value that should be in filed value.
     * @return Returns query for all indexed properties.
     * @throws IOException
     * @throws ParseException
     */
    public Query getQuerнForAllParams(String querystr) throws IOException, ParseException{
        final String FIELD_NAME = "name";
        IndexConfig indexConfig = IndexParametersConfig.getInstance();
        IndexReader reader = DirectoryReader.open(IndexParametersConfig.getInstance().getIndexDirectory());

        Set<String> propertiesSet = new HashSet<String>();
        Query query;
//configureme        List<String> properties = CONFIG_PROPERTIES.getProperties();
        for (int i = 0; i < reader.numDocs(); i++) {
            Document doc = reader.document(i);
            propertiesSet.addAll(Arrays.asList(doc.getValues(FIELD_NAME)));

//            queries[i] = new QueryParser(indexConfig.getVersion(), doc.get("name"), indexConfig.getAnalyzer()).parse(query);
        }
        String[] properties = propertiesSet.toArray(new String[propertiesSet.size()]);
        query = new MultiFieldQueryParser(indexConfig.getVersion(), properties, indexConfig.getAnalyzer()).parse(querystr);

        return query;
    }

}
