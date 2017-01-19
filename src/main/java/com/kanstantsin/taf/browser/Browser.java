package com.kanstantsin.taf.browser;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

    private static volatile RemoteWebDriver driver;

    private Browser(){}

    public static RemoteWebDriver getDriver() {
        if(driver == null){
            synchronized (Browser.class){
                if(driver == null){
                    String driverType = System.getProperty("driverType");
                    return driver = DriverFactory.createDriver(driverType);
                }
            }
        }
        return driver;
    }
}
