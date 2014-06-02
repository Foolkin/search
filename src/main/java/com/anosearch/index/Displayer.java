package com.anosearch.index;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;

/**
 * Created by admin on 5/20/14.
 */
public class Displayer {
    private Displayer() {
        throw new AssertionError("shouldn't be created");
    }

    public static void output(Document[] documents) {
        for (Document doc : documents) {
            System.out.print(">> ");
            for (IndexableField field : doc.getFields())
                System.out.print(field.name() + " | ");
            System.out.print("<<\n");
//            System.out.println(".|. " + doc.get("title") + "\t" + doc.get("body"));
        }
    }
}
