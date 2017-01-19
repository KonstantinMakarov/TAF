package com.kanstantsin.taf.browser.customzer;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxGenerator implements DriverGenerator {
    public RemoteWebDriver generateDriver() {
        return new FirefoxDriver();
    }
}
