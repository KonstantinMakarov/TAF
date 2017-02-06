package com.kanstantsin.taf.utils.property;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum GridPropertiesProvider {

    URL("grid.url"),
    PLATFORM("grid.platform"),
    BROWSER_NAME("grid.browserName");

    public String getProperty() {
        return property;
    }

    private String property;

    GridPropertiesProvider(String value){
        InputStream inputStream = GridPropertiesProvider.class.getClassLoader().getResourceAsStream("grid.properties");
        Properties gridProperties = new Properties();
        try {
            gridProperties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load 'grid.properties' from resources: " + e.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        this.property = gridProperties.getProperty(value);
    }
}
