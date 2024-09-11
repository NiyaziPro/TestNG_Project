package techproed.tests.day19_pageobjectmodel_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C06_BlueRentalExcelTest {

    @Test
    public void testBlueRentalExcel() { // DATA DRIVEN TESTING

        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));

        //Login buttonuna tıklayalım
        BlueRentalCarPage brc = new BlueRentalCarPage();


        //Excel dosyasındaki tum  email ve password ile login olalım
        String filePath = "src/test/java/techproed/resources/adminTestData.xlsx";
        String sheetName = "customer_info";

        ExcelReader excelReader = new ExcelReader(filePath, sheetName);

        for (int i = 1; i <= excelReader.rowCount(); i++) {
            String email = excelReader.getCellData(i, 0);
            String password = excelReader.getCellData(i,  1);
            brc.loginButton.click();
            brc.emailBox.sendKeys(email);
            brc.passwordBox.sendKeys(password, Keys.ENTER);

            brc.dropDownMenu.click();
            ReusableMethods.visibleWait(brc.dropDownMenu, 5);
            Assert.assertTrue(brc.profileLink.isDisplayed());

            brc.logoutLink.click();
            brc.oKButton.click();

        }

        Driver.closeDriver();

    }
}
