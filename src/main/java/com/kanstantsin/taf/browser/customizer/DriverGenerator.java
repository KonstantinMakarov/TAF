package com.kanstantsin.taf.browser.customizer;

import org.openqa.selenium.remote.RemoteWebDriver;

@FunctionalInterface
public interface DriverGenerator {
    RemoteWebDriver generateDriver();
}
