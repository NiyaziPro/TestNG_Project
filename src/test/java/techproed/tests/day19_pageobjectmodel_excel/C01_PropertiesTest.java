package techproed.tests.day19_pageobjectmodel_excel;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PropertiesTest {





    @Test
    public void test01() {

        OpenSourcePage openSourcePage = new OpenSourcePage();

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperties("openSourceUrl"));

        //kullanici=Admin
        //kullaniciSifre=admin123
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        openSourcePage.username.sendKeys(ConfigReader.getProperties("openSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperties("openSourcePassword"));
        openSourcePage.loginButton.submit();

        //Login Testinin basarili oldugunu test edelim

        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        // Yeni acilan sayfanin ekran goruntusunu alalim

        ReusableMethods.screenShot("open source screenshot");

        // dashboard SS

        ReusableMethods.screenShotOfWebElement(openSourcePage.dashboard);

        //sayfayi kapatalim
        ReusableMethods.waitForSecond(1);

        Driver.closeDriver();
    }
}
