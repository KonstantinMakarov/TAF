package tests;

import com.kanstantsin.taf.browser.Browser;
import com.kanstantsin.taf.listeners.CustomTestListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(CustomTestListener.class)
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
