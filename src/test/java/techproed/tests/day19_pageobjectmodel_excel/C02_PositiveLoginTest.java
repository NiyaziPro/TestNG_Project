package techproed.tests.day19_pageobjectmodel_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PositiveLoginTest {

    //Name: US100201_Admin_Login
    //Description:
    //Login with admin information
    //Acceptance Criteria:
    //As admin, I should be able to log in to the application
    //email: ada@ada.com
    //password: 12345
    //https://www.bluerentalcars.com/

    //Name: US100201_Admin_Login
    //Description:
    //Admin bilgileriyle giriş
    //Acceptance Criteria:
    //Admin olarak, uygulamaya giriş yapabilmeliyim
    //email : ada@ada.com
    //password: 12345
    //https://www.bluerentalcars.com/
    @Test
    public void test01() { // Bu test hem POSITIVE TEST hem SMOKE TEST

        //Name: US01_Admin_Login
        //Description: Admin bilgileriyle giriş
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //email : ada@ada.com
        //password: 12345
        //https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.emailBox.sendKeys(ConfigReader.getProperties("blueRentalEmail"));
        blueRentalCarPage.passwordBox.sendKeys(ConfigReader.getProperties("blueRentalPassword"), Keys.ENTER);

        Assert.assertTrue(blueRentalCarPage.dropDownMenu.isDisplayed());

        Driver.closeDriver();


    }
}