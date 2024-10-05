package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;

import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;

public class TC001 extends PreConditionLogged {

    @Test(description = "TC001 - Kullanıcı search'box tan istediği bir ürünü arayabilmeli")
    public void testSearchProductFromSearchBox() {
        MainPage mainPage = new MainPage();


        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("Macbook");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();

        ExtentReportUtils.extentTestInfo("Search box tan istediği bir ürünü arayabildigini dogrular.");
        Assert.assertTrue(mainPage.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının search box tan istediği bir ürünü arayabildigi doğrulandı.");



    }


}
