package com.kanstantsin.taf.browser.customzer;

import com.google.common.base.Optional;
import com.kanstantsin.taf.utils.property.GridPropertiesProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridGenerator implements DriverGenerator {
    final String seleniumHost = System.getProperty("selenium_host");
    final String seleniumPort = System.getProperty("selenium_port");

    public RemoteWebDriver generateDriver() {
        try {
            if (seleniumHost == null || seleniumPort == null) {
                return new RemoteWebDriver(new URL(GridPropertiesProvider.URL.getProperty()), createDesiredCapabilities());
            } else {
                Optional<URL> url = Optional.of(new URL("http://" + seleniumHost + ":" + seleniumPort + "/wd/hub"));
                return new RemoteWebDriver(url.get(), createDesiredCapabilities());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(String.format("Could not create URL with selenium_host=%s and selenium_port=%s\n",
                                        seleniumHost, seleniumPort)
                    + e.getMessage());
        }
    }

    private  Capabilities createDesiredCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", GridPropertiesProvider.PLATFORM.getProperty());
        cap.setCapability("browserName", GridPropertiesProvider.BROWSER_NAME.getProperty());
        return cap;
    }
}
