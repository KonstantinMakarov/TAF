package com.kanstantsin.taf.utils;

import com.kanstantsin.taf.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitUtils {

    public static final int DEFAULT_WAIT_TIME = 10;
    protected static final Logger LOG = LoggerFactory.getLogger(WaitUtils.class);

    private WaitUtils() {}

    public static void waitForPageToLoadViaJS(){
        waitForPageToLoadViaJS(DEFAULT_WAIT_TIME);
    }

    public static void waitForPageToLoadViaJS(int customWaitTime){
        LOG.info(String.format("Wait for page to be load in %s seconds", customWaitTime));
        new WebDriverWait(Browser.getDriver(), customWaitTime) {
        }.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return "complete".equals(getDocumentReadyState());
            }
        });
        LOG.info("Page has been loaded");
    }

    private static String getDocumentReadyState() {
        return (String) (Browser.getDriver()).executeScript("return document.readyState");
    }

    public static void waitForElement(By selector) {
        Wait<WebDriver> wait = new WebDriverWait(Browser.getDriver(), DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
