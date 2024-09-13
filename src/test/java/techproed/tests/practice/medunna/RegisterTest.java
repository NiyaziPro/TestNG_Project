package techproed.tests.practice.medunna;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class RegisterTest {


    @Test(description = "US02 - Kullanici gecerli fake data'lar ile register olabilmeli")
    public void testMedunnaRegister() {
        MedunnaPage medunnaPage = new MedunnaPage();
        Faker faker = new Faker();

        Driver.getDriver().get(ConfigReader.getProperties("medunnaUrl"));

        medunnaPage.accountMenuDropDown.click();
        medunnaPage.registerButton.click();

        medunnaPage.ssnTextBox.sendKeys(faker.idNumber().ssnValid());
        medunnaPage.firstNameTextBox.sendKeys(faker.name().firstName());
        medunnaPage.lastNameTextBox.sendKeys(faker.name().lastName());
        medunnaPage.userNameTextBox.sendKeys(faker.name().username());
        medunnaPage.emailTextBox.sendKeys(faker.internet().emailAddress());

        String password = faker.internet().password(10, 15, true, true, true);

        medunnaPage.firstPasswordTextBox.sendKeys(password);
        medunnaPage.secondPasswordTextBox.sendKeys(password);

        ReusableMethods.scrollEnd();
        ReusableMethods.waitForSecond(2);

        medunnaPage.registerSubmitButton.click();

        ReusableMethods.visibleWait(medunnaPage.registrationSavedText, 10);

        Assert.assertTrue(medunnaPage.registrationSavedText.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void testMedunnaRegister2() {
        MedunnaPage medunnaPage = new MedunnaPage();
        Faker faker = new Faker();

        Driver.getDriver().get(ConfigReader.getProperties("medunnaUrl"));

        medunnaPage.accountMenuDropDown.click();
        medunnaPage.registerButton.click();

        String password = faker.internet().password(10, 15, true, true, true);

        medunnaPage.ssnTextBox.sendKeys(faker.idNumber().ssnValid(),
                Keys.TAB,
                faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.name().username(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                password,
                Keys.TAB,
                password,
                Keys.TAB,
                Keys.ENTER);

        ReusableMethods.visibleWait(medunnaPage.registrationSavedText, 10);

        Assert.assertTrue(medunnaPage.registrationSavedText.isDisplayed());

        Driver.closeDriver();

    }

    @Test(description = "US02 - Kullanici gecerli fake data'lar ile register olabilmeli")
    public void testMedunnaRegister3() {
        MedunnaPage medunnaPage = new MedunnaPage();
        Faker faker = new Faker();

        Driver.getDriver().get(ConfigReader.getProperties("medunnaUrl"));

        medunnaPage.accountMenuDropDown.click();
        medunnaPage.registerButton.click();

        medunnaPage.ssnTextBox.sendKeys(faker.idNumber().ssnValid());

        String firstName = faker.name().firstName();
        medunnaPage.firstNameTextBox.sendKeys(firstName);

        String lastName = faker.name().lastName();
        medunnaPage.lastNameTextBox.sendKeys(lastName);

        String username = firstName + lastName;
        medunnaPage.userNameTextBox.sendKeys(username);

        medunnaPage.emailTextBox.sendKeys(faker.internet().emailAddress());

        String password = faker.internet().password(8, 12, true, true, true);

        medunnaPage.firstPasswordTextBox.sendKeys(password);
        medunnaPage.secondPasswordTextBox.sendKeys(password,Keys.ENTER);


        ReusableMethods.visibleWait(medunnaPage.registrationSavedText, 10);

        Assert.assertTrue(medunnaPage.registrationSavedText.isDisplayed());

        Driver.closeDriver();

    }
}
