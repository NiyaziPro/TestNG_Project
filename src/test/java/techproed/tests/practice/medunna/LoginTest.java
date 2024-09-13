package techproed.tests.practice.medunna;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class LoginTest {


    @Test(description = "US01 - Kullanici gecerli data'lar ile siteye giris yapabilmeli")
    public void testLogin() {
        // POSITIVE SMOKE TEST
        //ILK ONCE GECERLI DATALAR ILE TESTIMI GERCEKLESTIRMELIYIM.

        MedunnaPage medunnaPage = new MedunnaPage();

        Driver.getDriver().get(ConfigReader.getProperties("medunnaUrl"));
        medunnaPage.accountMenuDropDown.click();
        medunnaPage.loginButton.click();

        medunnaPage.userNameTextBox.sendKeys(ConfigReader.getProperties("adminUserName"));
        medunnaPage.passwordBox.sendKeys(ConfigReader.getProperties("adminPassword"), Keys.ENTER);

        Assert.assertEquals(medunnaPage.loginVerify.getText(), ConfigReader.getProperties("userName"), "Error");
        Driver.closeDriver();

    }


}
