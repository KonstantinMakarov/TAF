package tests.factory;

import business.page.HomePage;
import com.kanstantsin.taf.utils.Sleeper;
import tests.BaseTest;
import org.testng.annotations.Test;

public class FactoryExampleCaseTest extends BaseTest {

    HomePage homePage = new HomePage();
    private String bouquetNumber = "0420";

    FactoryExampleCaseTest(String bouquetNumber) {
        this.bouquetNumber = bouquetNumber;
    }

    FactoryExampleCaseTest() {}

    @Test
    public void run(){
        driver.get("http://zelotos.ru/");
        homePage.clickOnBouquetLinkByNumber(bouquetNumber);
        Sleeper.sleepInSeconds(20);
    }

}
