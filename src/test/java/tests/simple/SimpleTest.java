package tests.simple;

import business.page.HomePage;
import com.kanstantsin.taf.utils.Sleeper;
import tests.BaseTest;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void run(){
        driver.get("http://zelotos.ru/");
        homePage.clickOnBouquetLinkByNumber("0420");
        Sleeper.sleepInSeconds(20);
    }

}
