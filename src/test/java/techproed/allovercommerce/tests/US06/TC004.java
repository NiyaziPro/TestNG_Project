package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC004 extends PreConditionAccessTheWebsite {


    @Test(description = "Kullanıcı Sign In olmadan searchbox'tan istediği bir ürünü arayabilmeli")
    public void testSearchProductWithoutSignIn() {


        ExtentReportUtils.extentTestInfo("Search box'a  istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Iphone 15");

        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();

        ExtentReportUtils.extentTestInfo("Search box tan istediği bir ürünü arayabildigini dogrular.");
        Assert.assertTrue(mainPages.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının Sign In olmadan searchbox'tan istediği bir ürün arayabildigi doğrulandı.");


    }


}
