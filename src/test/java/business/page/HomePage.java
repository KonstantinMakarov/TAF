package business.page;

import com.kanstantsin.taf.element.Element;
import org.openqa.selenium.By;

public class HomePage {

    private static final String BOUQUET_NUMBER = "//div[@id='buket' and contains(., '%s')]//div[contains(@class, 'title-buket')]//a";

    public HomePage clickOnBouquetLinkByNumber(String bouquetNumber) {
        new Element(By.xpath(String.format(BOUQUET_NUMBER, bouquetNumber))).click();
        return this;
    }
}
