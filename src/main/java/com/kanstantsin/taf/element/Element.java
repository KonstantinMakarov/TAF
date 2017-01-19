package com.kanstantsin.taf.element;

import com.kanstantsin.taf.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kanstantsin.taf.utils.WaiterUtils;

public class Element {

    protected static final Logger LOG = LoggerFactory.getLogger(Element.class);

    private By selector;
    private WebElement webElement;

    public Element (By selector){
        this.selector = selector;
    }

    public void click() {
        LOG.info(String.format("Click on '%s'", selector));
        waitForDisplayed();
        webElement.click();
    }

    protected void waitForDisplayed() {
        WaiterUtils.waitForPageToLoadViaJS();
        Wait<WebDriver> wait = new WebDriverWait(Browser.getDriver(), WaiterUtils.DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        webElement = Browser.getDriver().findElement(selector);
    }
}
