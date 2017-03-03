package com.kanstantsin.taf.browser.customizer;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeGenerator implements DriverGenerator{
    public RemoteWebDriver generateDriver() {
        return new ChromeDriver();
    }
}
