package tests;

import com.kanstantsin.taf.browser.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public abstract class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = Browser.getDriver();
    }

    @AfterTest
    public void shutDown(){
        driver.quit();
    }
}
