package techproed.tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import techproed.pages.DemoPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class P01_Practice {

    //Go to https://demo.automationtesting.in/Register.html
    //fill firstname, secondname, address fields with faker
    // Get the fake email by going to https://www.fakemail.net/
    // go back and fill in the email address field with this email
    // upload a file to the page


    //https://demo.automationtesting.in/Register.html adresine gidin
    // faker ile firstname, secondname, adress alanlarini doldurun
    // https://www.fakemail.net/ adresine giderek fake maili alin
    // geri dönün ve email adress kısmını bu email ile doldurun
    // sayfaya bir dosya yükleyin
    //Diğer alanları doldurun

    Faker faker = new Faker();
    DemoPage demoPage = new DemoPage();

    @Test(description = "US03 - Kullanici register islemi yapar")
    public void testDemoAutomationRegister() {
        //https://demo.automationtesting.in/Register.html adresine gidin

        Driver.getDriver().get(ConfigReader.getProperties("automationTestingUrl"));

        ReusableMethods.waitForSecond(3);
        // faker ile firstname, secondname, adress alanlarini doldurun
        demoPage.firstName.sendKeys(faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.address().fullAddress());

        // https://www.fakemail.net/ adresine giderek fake maili alin
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.fakemail.net/");
        String fakeEmail = demoPage.fakeEmail.getText();

        // geri dönün ve email adress kısmını bu email ile doldurun
        ReusableMethods.switchToWindow(0);

        demoPage.emailBox.sendKeys(fakeEmail,
                Keys.TAB,
                faker.phoneNumber().cellPhone());

        // sayfaya bir dosya yükleyin
        String path = System.getProperty("user.home") + "\\Downloads\\image (2).png";
        demoPage.chooseFile.sendKeys(path);

        //Diğer alanları doldurun
        demoPage.genderRadioButton.click();
        demoPage.checkBox2.click();

        demoPage.languageDropDownBox.click();
        ReusableMethods.scrollEnd();
        demoPage.optionLanguageTurkish.click();

        ReusableMethods.ddmIndex(demoPage.skillsDropDownBox,3);
        ReusableMethods.ddmIndex(demoPage.countriesDropDownBox,0);
        ReusableMethods.ddmVisibleText(demoPage.selectCountryDropDownBox,"Japan");
        ReusableMethods.ddmValue(demoPage.yearDropDownBox, "1990");
        ReusableMethods.ddmValue(demoPage.monthDropDownBox, "January");
        ReusableMethods.ddmIndex(demoPage.dayDropDownBox, 29);

        String password = faker.internet().password(8, 12, true, true, true);
        demoPage.firstPasswordBox.sendKeys(password);
        demoPage.confirmPasswordBox.sendKeys(password);

        demoPage.submitButton.click();





    }
}
