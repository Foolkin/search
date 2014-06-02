package com.anosearch.index;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;

/**
 * IdField extends {@link org.apache.lucene.document.Field}
 * Uses only for storage id. Not indexed. Always stored.
 */
public class IdField extends Field {

    /** Indexed, tokenized, stored. */
    public static final FieldType TYPE = new FieldType();

    static {
        TYPE.setIndexed(false);
        TYPE.setStored(true);
        TYPE.freeze();
    }

    /**
     * Constructor. Calls Field constructor, type always - STORED.
     * @param name Field name.
     * @param value String value.
     */
    public IdField(String name, String value) {
        super(name, value, TYPE);
    }
}
