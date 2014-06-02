package com.anosearch.index.anodoc;

import com.anosearch.index.Indexable;
import net.anotheria.anodoc.data.Document;
import net.anotheria.anodoc.data.Property;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 5/20/14.
 */
public class AnoDocWrapper implements Indexable, Iterable<IndexableField> {
    private Document anoDoc;

    private ArrayList<IndexableField> properties = new ArrayList<IndexableField>();

    public AnoDocWrapper(Document anoDoc) {
        this.anoDoc = anoDoc;
        fillProperies();
        registerPropertyTypes();
    }

    public void fillProperies(){
        for(Property prop : anoDoc.getProperties())
            properties.add(new TextField(prop.getId(), (String) prop.getValue(), Field.Store.YES));
    }

    public void registerPropertyTypes(){
        for(Property prop : anoDoc.getProperties())
            AnoDocPropertyTypes.getInstance().addPropety(prop.getId());
    }

    public List<Property> getAnoDocProperties(){
        return anoDoc.getProperties();
    }

    public Document getDocument(){
        return anoDoc;
    }

    @Override
    public Iterator<IndexableField> iterator() {
        return properties.iterator();
    }
}
