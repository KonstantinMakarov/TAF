package com.kanstantsin.taf.browser.customizer;

import com.gargoylesoftware.htmlunit.util.UrlUtils;
import com.google.common.base.Optional;
import com.kanstantsin.taf.utils.property.GridPropertiesProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class GridGenerator implements DriverGenerator {
    private final String seleniumHost = System.getProperty("selenium_host");
    private final String seleniumPort = System.getProperty("selenium_port");
    private static final Logger LOG = LoggerFactory.getLogger(GridGenerator.class);

    public RemoteWebDriver generateDriver() {
        if (seleniumHost == null || seleniumPort == null) {
            return new RemoteWebDriver(UrlUtils.toUrlSafe(GridPropertiesProvider.URL.getProperty()), createDesiredCapabilities());
        } else {
            Optional<URL> url = Optional.of(UrlUtils.toUrlSafe("http://" + seleniumHost + ":" + seleniumPort + "/wd/hub"));
            return new RemoteWebDriver(url.get(), createDesiredCapabilities());
        }
    }

    private  Capabilities createDesiredCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", GridPropertiesProvider.PLATFORM.getProperty());
        cap.setCapability("browserName", GridPropertiesProvider.BROWSER_NAME.getProperty());
        return cap;
    }
}
