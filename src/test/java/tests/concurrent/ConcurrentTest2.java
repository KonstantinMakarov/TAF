package tests.concurrent;

import com.kanstantsin.taf.utils.Sleeper;
import tests.BaseTest;
import com.kanstantsin.taf.element.Element;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ConcurrentTest2 extends BaseTest {

    @Test
    public void run(){
        driver.get("http://www.google.com");
        new Element(By.xpath("//input[@value='Мне пашчасціць']")).click();
        Sleeper.sleepInSeconds(20);
    }

}