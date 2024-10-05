package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;

public class TC002 extends PreConditionLogged {

    @Test(description = "TC002 - Kullanıcı search'box tan istediği bir ürünü arayabilmeli.")
    public void testSearchProductFromSearchBoxWithClickEnter() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("Macbook");
        ExtentReportUtils.extentTestInfo("Enter tusuna tıklar.");
        mainPage.homePage.searchboxButton.sendKeys(Keys.ENTER);

        ExtentReportUtils.extentTestInfo("Search box tan istediği bir ürünü arayabildigini dogrular.");
        Assert.assertTrue(mainPage.productPage.searchResultsFor.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının search box tan istediği bir ürünü arayabildigi doğrulandı.");


    }


}
