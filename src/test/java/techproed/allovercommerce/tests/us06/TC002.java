package techproed.allovercommerce.tests.us06;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;

public class TC002 extends PreCondition{

    @Test(description = "TC002 - Kullanıcı search'box tan istediği bir ürünü arayabilmeli.")
    public void testSearchProductFromSearchBoxWithClickEnter() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Macbook");
        ExtentReportUtils.extentTestInfo("Enter tusuna tıklar.");
        mainPages.homePage.searchboxButton.sendKeys(Keys.ENTER);

        Assert.assertTrue(mainPages.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Search box tan istediği bir ürünü arayabildigini dogrular.");


    }

    @AfterClass
    public void afterClass() {
        ExtentReportUtils.extentTestInfo("Sayfa kapatıldı.");
        Driver.closeDriver();
    }


}
