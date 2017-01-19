package com.kanstantsin.taf.browser;

import com.kanstantsin.taf.browser.customzer.ChromeGenerator;
import com.kanstantsin.taf.browser.customzer.DriverGenerator;
import com.kanstantsin.taf.browser.customzer.FirefoxGenerator;
import com.kanstantsin.taf.browser.customzer.IEGenerator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DriverFactory {

    FIREFOX(new FirefoxGenerator(), "gecko", "geckodriver.exe", "Firefox"),
    CHROME(new ChromeGenerator(), "chrom", "chromedriver.exe", "Chrome"),
    IE(new IEGenerator(), "ie", "IEDriverServer.exe", "IE");

    private static Logger LOG = LoggerFactory.getLogger(DriverFactory.class);
    private DriverGenerator driverClass;
    private String driverTypeKey;
    private String driverTypeValue;
    private String driverType;
    public final String DRIVER_TYPE_VALUE_WIN = System.getProperty("basedir") + "\\src\\main\\resources\\com\\kanstantsin\\taf\\driver\\";
    public final String DRIVER_TYPE_KEY_TEMPLATE = "webdriver.%s.driver";

    DriverFactory(DriverGenerator driver, String driverKey, String driverValue, String driverType) {
        this.driverClass = driver;
        this.driverTypeKey = String.format(DRIVER_TYPE_KEY_TEMPLATE, driverKey);
        this.driverTypeValue = DRIVER_TYPE_VALUE_WIN + driverValue;
        this.driverType = driverType;
    }

    public static RemoteWebDriver createDriver(String desiredDriverType){
        for(DriverFactory browser: DriverFactory.values()){
            if(browser.driverType.equals(desiredDriverType)){
                System.setProperty(
                        browser.driverTypeKey,
                        browser.driverTypeValue
                );
                LOG.info(String.format("Perform setProperty: [%s : %s]", browser.driverTypeKey, browser.driverTypeValue));
                return browser.driverClass.generateDriver();
            }
        }
        throw new RuntimeException("Unknown driver type in '-DdriverType' parameter");
    }
}
