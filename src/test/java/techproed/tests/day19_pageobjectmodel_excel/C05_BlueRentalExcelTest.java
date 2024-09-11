package techproed.tests.day19_pageobjectmodel_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C05_BlueRentalExcelTest {


    @Test
    public void testBlueRentalExcel() {

        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));

        //Login buttonuna tıklayalım
        BlueRentalCarPage brc =new BlueRentalCarPage();
        brc.loginButton.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String filePath = "src/test/java/techproed/resources/adminTestData.xlsx";
        String sheetName = "customer_info";

        ExcelReader excelReader = new ExcelReader(filePath, sheetName);

        String email = excelReader.getCellData(1,0);
        String password = excelReader.getCellData(1,1);
        brc.emailBox.sendKeys(email);
        brc.passwordBox.sendKeys(password, Keys.ENTER);

        //Girilen email ile giriş yapıldığını doğrulayın

        brc.dropDownMenu.click();
        ReusableMethods.visibleWait(brc.dropDownMenu, 5);

        brc.profileLink.click();

        String profileEmailVerify = brc.emailVerify.getText();

        Assert.assertEquals(profileEmailVerify,email);


        //sayfayı kapatalım
        Driver.closeDriver();

    }
}
