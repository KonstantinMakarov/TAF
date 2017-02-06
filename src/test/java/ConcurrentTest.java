import com.kanstantsin.taf.browser.Browser;
import com.kanstantsin.taf.element.Element;
import com.kanstantsin.taf.utils.TimeoutUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConcurrentTest {
    RemoteWebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = Browser.getDriver();
    }

    @Test
    public void run(){
        driver.get("http://www.google.com");
        new Element(By.xpath("//input[@value='Мне пашчасціць']")).click();
    }

    @AfterTest
    public void shutDown(){
        TimeoutUtils.sleepInSeconds(10);
        driver.quit();
    }
}

