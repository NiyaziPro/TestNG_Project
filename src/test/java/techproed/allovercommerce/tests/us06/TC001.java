package techproed.allovercommerce.tests.us06;

import org.testng.Assert;
import org.testng.annotations.Test;

import techproed.utilities.ExtentReportUtils;

public class TC001 extends PreConditionLogged {

    @Test(description = "TC001 - Kullanıcı search'box tan istediği bir ürünü arayabilmeli")
    public void testSearchProductFromSearchBox() {


        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Macbook");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();

        ExtentReportUtils.extentTestInfo("Search box tan istediği bir ürünü arayabildigini dogrular.");
        Assert.assertTrue(mainPages.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının search box tan istediği bir ürünü arayabildigi doğrulandı.");



    }


}
