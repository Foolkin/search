package com.anosearch.index;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains all types of properties that was indexed.
 */
public abstract class PropertyTypes {
    protected Set<String> propertySet;

    protected PropertyTypes(){
        propertySet = new HashSet<String>();
    }

    public void addPropety(String property){
        propertySet.add(property);
    }

    public void removeProperty(String property){
        propertySet.remove(property);
    }

    public Set<String> getPropertySet(){
        return propertySet;
    }
}
