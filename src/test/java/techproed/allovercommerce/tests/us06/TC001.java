package techproed.allovercommerce.tests.us06;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;

public class TC001 extends PreCondition{

    @Test(description = "TC001 - Kullanıcı search'box tan istediği bir ürünü arayabilmeli")
    public void testSearchProductFromSearchBox() {


        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Macbook");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();

        Assert.assertTrue(mainPages.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Search box tan istediği bir ürünü arayabildigini dogrular.");



    }


}
