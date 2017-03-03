package com.kanstantsin.taf.browser.customizer;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IEGenerator implements DriverGenerator {
    public RemoteWebDriver generateDriver() {
        return new InternetExplorerDriver();
    }
}
