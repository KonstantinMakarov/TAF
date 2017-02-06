import com.kanstantsin.taf.browser.Browser;
import com.kanstantsin.taf.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {

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

    @AfterClass
    public void shutDown(){
        driver.quit();
    }
}