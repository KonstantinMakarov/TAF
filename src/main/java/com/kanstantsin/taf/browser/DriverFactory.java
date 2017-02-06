package com.kanstantsin.taf.browser;

import com.kanstantsin.taf.browser.customzer.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public enum DriverFactory {

    FIREFOX(new FirefoxGenerator(), "gecko", "geckodriver.exe", "firefox"),
    CHROME(new ChromeGenerator(), "chrom", "chromedriver.exe", "chrome"),
    IE(new IEGenerator(), "ie", "IEDriverServer.exe", "ie"),
    GRID(new GridGenerator(), "NONE", "NONE", "grid");

    private static Logger LOG = LoggerFactory.getLogger(DriverFactory.class);
    private DriverGenerator driverClass;
    private String driverTypeKey;
    private String driverTypeValue;
    private String driverType;
    public final String DRIVER_TYPE_VALUE_WIN = System.getProperty("basedir", System.getProperty("user.dir")) + "\\src\\main\\resources\\com\\kanstantsin\\taf\\driver\\";
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
                return customizeGeneratedDriver(browser.driverClass.generateDriver());
            }
        }
        throw new RuntimeException("Unknown driver type in '-DdriverType' parameter");
    }

    private static RemoteWebDriver customizeGeneratedDriver(RemoteWebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                org.apache.commons.lang3.StringUtils.isNumeric(System.getProperty("IMPLICITLY_WAIT_SEC"))
                        ? NumberUtils.toInt(System.getProperty("IMPLICITLY_WAIT_SEC")) : 20,
                TimeUnit.SECONDS);
        return driver;
    }
}
