package techproed.tests.day18_pageobjectmodel;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.TechProEdPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C06_PropertiesUsage {


    @Test
    public void test01() {
        String url = ConfigReader.getProperties("amazonUrl");
        Driver.getDriver().get(url);
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("macboook", Keys.ENTER);


        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        TechProEdPage techProEdPage = new TechProEdPage();
        techProEdPage.searchBox.sendKeys("Selenium",Keys.ENTER);
    }
}
