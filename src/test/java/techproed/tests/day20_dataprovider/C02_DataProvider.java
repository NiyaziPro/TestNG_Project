package techproed.tests.day20_dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.Objects;

public class C02_DataProvider {


    @DataProvider(name = "googleProduct")
    public static Object[][] products() {
        return new Object[][]{
                {"Macbook"},
                {"Iphone"},
                {"Ipad"},
                {"Keyboard"}
        };
    }

    @Test(dataProvider = "googleProduct")
    public void testGoogleSearch(String data) {
        GooglePage googlePage = new GooglePage();

        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        googlePage.handleCookie();

        //DataProvider ile istediğimiz ürünleri aratalım
        googlePage.searchBox.sendKeys(data, Keys.ENTER);


        //sayfayı kapatalım

        Driver.closeDriver();
    }


    @Test(dataProvider = "products")
    public void testAmazonSearch(String data) {

        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get(ConfigReader.getProperties("amazonUrl"));
        amazonPage.handleCaptcha();

        //DataProvider ile istediğimiz ürünleri aratalım
        amazonPage.searchBox.sendKeys(data, Keys.ENTER);

        //sayfayı kapatalım

        Driver.closeDriver();
    }
}
