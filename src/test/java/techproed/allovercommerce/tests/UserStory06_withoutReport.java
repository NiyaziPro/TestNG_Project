package techproed.allovercommerce.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.*;

@Listeners(ExtentReportsListener.class)
public class UserStory06_withoutReport {

    MainPages mainPages = new MainPages();


    @Test(priority = -1)
    public void testpreCondition() {

        Driver.getDriver().get(ConfigReader.getProperties("allovercommerceUrl"));
        mainPages.homePage.signIn.click();
        mainPages.loginPage.usernameBox.sendKeys(ConfigReader.getProperties("alloverUsername"));

        mainPages.loginPage.passwordBox.sendKeys(ConfigReader.getProperties("alloverPassword"));

        mainPages.loginPage.signInButton.click();
        WaitUtils.waitFor(4);
    }


    @Test(description = "TC001 - Kullanıcı search'box tan istediği bir ürünü arayabilmeli" )
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

    @Test(description = "TC003 - Kullanıcı search box'tan sitede olmayan (alakasız) bir ürünü arattığında ürünün bulunamadıgı mesajı görmeli." )
    public void testSearchIrrelevantProductFromSearchBox() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Sitede olmayan (alakasız) bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Selenium");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();

        Assert.assertTrue(mainPages.productPage.noProductWereFoundMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Ürünün bulunamadıgına dagir mesaj gördügünü  dogrular.");

    }



    @AfterMethod
    public void tearDown() {
               Driver.closeDriver();

    }
}
