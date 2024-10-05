package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;

public class TC004 extends PreConditionAccessTheWebsite {


    @Test(description = "TC004 - Kullanıcı Sign In olmadan searchbox'tan istediği bir ürünü arayabilmeli")
    public void testSearchProductWithoutSignIn() {
        MainPage mainPage = new MainPage();


        ExtentReportUtils.extentTestInfo("Search box'a  istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("Iphone 15");

        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();

        ExtentReportUtils.extentTestInfo("Search box tan istediği bir ürünü arayabildigini dogrular.");
        Assert.assertTrue(mainPage.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının Sign In olmadan searchbox'tan istediği bir ürün arayabildigi doğrulandı.");


    }


}
