package com.kanstantsin.taf.utils;

import com.kanstantsin.taf.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitUtils {

    public static final int DEFAULT_WAIT_TIME = 60;
    protected static final Logger LOG = LoggerFactory.getLogger(WaitUtils.class);

    public static void waitForPageToLoadViaJS(){
        waitForPageToLoadViaJS(DEFAULT_WAIT_TIME);
    }

    public static void waitForPageToLoadViaJS(int customWaitTime){
        new WebDriverWait(Browser.getDriver(), customWaitTime) {
        }.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return getDocumentReadyState().equals("complete");
            }
        });
    }

    private static String getDocumentReadyState() {
        return (String) (Browser.getDriver()).executeScript("return document.readyState");
    }
}
