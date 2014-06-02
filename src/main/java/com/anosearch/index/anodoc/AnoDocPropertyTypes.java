package com.anosearch.index.anodoc;

import com.anosearch.index.PropertyTypes;

/**
 * Created by admin on 5/21/14.
 */
public class AnoDocPropertyTypes extends PropertyTypes {
    private AnoDocPropertyTypes(){
        super();
    }

    private static class InstanceHolder{
        private final static AnoDocPropertyTypes instance = new AnoDocPropertyTypes();
    }

    public static AnoDocPropertyTypes getInstance(){
        return InstanceHolder.instance;
    }
}
