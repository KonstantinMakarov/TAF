package com.kanstantsin.taf.browser;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

    private static ThreadLocal<RemoteWebDriver> thread = new InheritableThreadLocal<RemoteWebDriver>();

    private Browser(){}

    public static RemoteWebDriver getDriver() {
        if(thread.get() == null){
            synchronized (Browser.class){
                if(thread.get() == null){
                    String driverType = System.getProperty("driverType");
                    thread.set(DriverFactory.createDriver(driverType));
                    return thread.get();
                }
            }
        }
        return thread.get();
    }
}
