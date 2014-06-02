package com.anosearch.index.anodoc;

import org.configureme.annotations.Configure;
import org.configureme.annotations.ConfigureMe;

import java.util.List;

/**
 * Created by admin on 6/2/14.
 */
@ConfigureMe (name = "some_name", allfields = true)
public class ConfigProperties {
    /**
     * List with names of properties.
     */
    private List<String> properties;

    /**
     * instance.
     */
    //not config impl
    @Configure()
    private static ConfigProperties instance;

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    /**
     *
     */
    private ConfigProperties() {
    }

    /**
     *
     * @return
     */
    public static final ConfigProperties getInstance() {
        if(instance == null) {
//          init
        }
        return instance;
    }
}
