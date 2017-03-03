package com.kanstantsin.taf.utils;

import com.kanstantsin.taf.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterUtils {

    public static final int DEFAULT_WAIT_TIME = 60;

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

    public static void sleepInMilliseconds(int mSeconds) {
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleepInSeconds(int seconds) {
        sleepInMilliseconds(1000 * seconds);
    }
}
