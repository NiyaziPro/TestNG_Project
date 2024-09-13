package techproed.tests.practice.medunna;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class PasswordStrength {
    MedunnaPage medunnaPage = new MedunnaPage();

    @Test
    public void testPasswordStrength() {
        Driver.getDriver().get(ConfigReader.getProperties("medunnaUrl"));

        medunnaPage.accountMenuDropDown.click();
        medunnaPage.registerButton.click();

        medunnaPage.firstPasswordTextBox.sendKeys("abcd");

        Assert.assertTrue(medunnaPage.passwordStrengthRed.isDisplayed(),"Error");

        ReusableMethods.waitForSecond(2);

        medunnaPage.firstPasswordTextBox.sendKeys("123");

        Assert.assertTrue(medunnaPage.passwordStrengthOrange.isDisplayed(),"Error");

        ReusableMethods.waitForSecond(2);

        medunnaPage.firstPasswordTextBox.sendKeys("+");

        Assert.assertTrue(medunnaPage.passwordStrengthGreen1.isDisplayed(),"Error");

        ReusableMethods.waitForSecond(2);

        medunnaPage.firstPasswordTextBox.sendKeys("ABC");

        Assert.assertTrue(medunnaPage.passwordStrengthGreen2.isDisplayed(),"Error");


        Driver.closeDriver();

    }
}
