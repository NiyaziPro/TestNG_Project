package techproed.tests.day19_pageobjectmodel_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_NegativeLoginTest {

    //Name: US01_Negative_Login

    //Description: Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali

    //Acceptance Criteria
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@bluerentalcars.com not found

    //BlueRentalCar sayfasına gidiniz
    //Login buttonuna tıklayalım
    //Properties dosyasındaki kullanımda olmayan email ve password bilgileri ile login olamadığını test edelim
    //sayfayı kapatınız


    @Test
    public void testNegativeLogin() {

        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.emailBox.sendKeys(ConfigReader.getProperties("fakeEmail"));
        blueRentalCarPage.passwordBox.sendKeys(ConfigReader.getProperties("fakePassword"), Keys.ENTER);

        ReusableMethods.visibleWait(blueRentalCarPage.negativeLoginVerify,10);
        Assert.assertTrue(blueRentalCarPage.negativeLoginVerify.isDisplayed());

        Driver.closeDriver();

    }
}
