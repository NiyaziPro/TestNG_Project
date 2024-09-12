package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C03_DataProviderTest {



    @DataProvider
    public static Object[][] credentials() {
        ExcelReader excelReader = new ExcelReader("src/test/java/techproed/resources/adminTestData.xlsx","customer_info");
        return new Object[][]{
                {ConfigReader.getProperties("blueRentalEmail1"),ConfigReader.getProperties("blueRentalPassword1")},
                {ConfigReader.getProperties("blueRentalEmail2"),ConfigReader.getProperties("blueRentalPassword2")},
                {ConfigReader.getProperties("blueRentalEmail2"),ConfigReader.getProperties("blueRentalPassword2")},
                {excelReader.getCellData(1,0),excelReader.getCellData(1,1)},
                {"ayhancan@bluerentalcars.com", "ayhan"},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }

    // BlueRentalCar Sayfasına Gidelim
    // Login butonuna tıklayalım
    // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
    // Sayfayı kapatalım

    //CREDENTIALS:
    //    {"ayhancan@bluerentalcars.com", "ayhan"},
    //    {"beyhancan@bluerentalcars.com", "beyhan"},
    //    {"johnson@bluerentalcars.com", "johnson"}


    @Test(dataProvider = "credentials")
    public void testBlueRentalCarLogin(String email, String password) {
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();

        // BlueRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));

        // Login butonuna tıklayalım
        blueRentalCarPage.loginButton.click();

        // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        blueRentalCarPage.emailBox.sendKeys(email);
        blueRentalCarPage.passwordBox.sendKeys(password, Keys.ENTER);

        Assert.assertTrue(blueRentalCarPage.dropDownMenu.isDisplayed());

        // Sayfayı kapatalım
        Driver.closeDriver();
    }
}
