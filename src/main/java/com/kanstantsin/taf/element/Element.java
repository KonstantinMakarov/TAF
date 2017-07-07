package com.kanstantsin.taf.element;

import com.kanstantsin.taf.browser.Browser;
import com.kanstantsin.taf.utils.Sleeper;
import com.kanstantsin.taf.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Element {

    private By selector;
    private WebElement webElement;

    protected static final Logger LOG = LoggerFactory.getLogger(Element.class);
    private static final int HIGHLIGHT_PAUSE_MILLISECONDS = 200;

    public Element (By selector){
        this.selector = selector;
    }

    public void click() {
        LOG.info("Try to click on '{}'", selector);
        waitForDisplayed();
        webElement.click();
        LOG.info("Successfully clicked on '{}'", selector);
    }

    protected void waitForDisplayed() {
        WaitUtils.waitForPageToLoadViaJS();
        WaitUtils.waitForElement(selector);
        webElement = Browser.getDriver().findElement(selector);
        highlightElement();
    }

    protected void highlightElement() {
        final String bgColor = webElement.getCssValue("background");
        (Browser.getDriver()).executeScript("arguments[0].style.background = 'yellow'", webElement);
        Sleeper.sleepInMilliseconds(HIGHLIGHT_PAUSE_MILLISECONDS);
        (Browser.getDriver()).executeScript("arguments[0].style.background = '" + bgColor + "'", webElement);
    }
}
