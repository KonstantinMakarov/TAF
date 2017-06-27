package com.kanstantsin.taf.utils.property;

import com.kanstantsin.taf.exceptions.PropertiesLoadingException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum GridPropertiesProvider {

    URL("grid.url"),
    PLATFORM("grid.platform"),
    BROWSER_NAME("grid.browserName");

    private String property;
    private final Logger LOG = LoggerFactory.getLogger(GridPropertiesProvider.class);

    GridPropertiesProvider(String value){
        InputStream inputStream = GridPropertiesProvider.class.getClassLoader().getResourceAsStream("grid.properties");
        Properties gridProperties = new Properties();
        try {
            gridProperties.load(inputStream);
        } catch (IOException e) {
            LOG.error("Could not load 'grid.properties' from resources: ", e.getMessage());
            throw new PropertiesLoadingException(e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        this.property = gridProperties.getProperty(value);
    }

    public String getProperty() {
        return property;
    }
}
