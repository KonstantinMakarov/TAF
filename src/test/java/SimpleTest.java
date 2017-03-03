import business.page.HomePage;
import com.kanstantsin.taf.browser.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {

    RemoteWebDriver driver;
    HomePage homePage = new HomePage();

    @BeforeClass
    public void setUp(){
        driver = Browser.getDriver();
    }

    @Test
    public void run(){
        driver.get("http://zelotos.ru/");
        homePage.clickOnBouquetLinkByNumber("0420");
    }

    @AfterClass
    public void shutDown(){
        driver.quit();
    }
}
