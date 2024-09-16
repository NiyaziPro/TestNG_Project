package techproed.tests.day18_pageobjectmodel;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.Driver;

public class C05_PageClassTest {

    OpenSourcePage openSourcePage = new OpenSourcePage();

    //Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //Log in by locating the UserName, UserPassword, submitButton elements
    //user=Admin
    //userPassword=admin123
    //Test that the Login Test is successful
    //close the page

    //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
    //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
    //kullanici=Admin
    //kullaniciSifre=admin123
    //Login Testinin basarili oldugunu test edelim
    //sayfayı kapatalim

    @Test(groups = "smoke")
    public void test01() {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        openSourcePage.username.sendKeys("Admin"); //kullanici=Admin
        openSourcePage.password.sendKeys("admin123"); //kullaniciSifre=admin123
        openSourcePage.loginButton.click();

        //Login Testinin basarili oldugunu test edelim

        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        //sayfayı kapatalim
        Driver.closeDriver();

    }
}
