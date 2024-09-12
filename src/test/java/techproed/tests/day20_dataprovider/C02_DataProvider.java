package techproed.tests.day20_dataprovider;


import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;


public class C02_DataProvider {


    @DataProvider(name = "amazonProducts")
    public static Object[][] products() {
        return new Object[][]{
                {"Macbook"},
                {"Iphone"},
                {"Ipad"},
                {"Keyboard"}
        };
    }

    @Test(dataProvider = "googleProducts")
    public void testGoogleSearch(String data) {
        GooglePage googlePage = new GooglePage();

        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        googlePage.handleCookies();

        //DataProvider ile istediğimiz ürünleri aratalım
        googlePage.searchBox.sendKeys(data, Keys.ENTER);


        //sayfayı kapatalım

        Driver.closeDriver();
    }


    @Test(dataProvider = "amazonProducts")
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
