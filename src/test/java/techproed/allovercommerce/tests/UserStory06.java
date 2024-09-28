package techproed.allovercommerce.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.*;
@Listeners(techproed.utilities.ExtentReportsListener.class)
public class UserStory06 {

    MainPages mainPages = new MainPages();


    @BeforeMethod
    public void preCondition() {
        ExtentReportUtils.setUpExtentReport("TestNG_Project");
        ExtentReportUtils.createExtentTest("Pre-condition", "Kullanıcı sisteme giriş yapmış olmalıdır.");


        ExtentReportUtils.extentTestInfo("Kullanıcı web sitesine gider.");
        Driver.getDriver().get(ConfigReader.getProperties("allovercommerceUrl"));

        ExtentReportUtils.extentTestInfo("\"Sign In\"  butonuna tıklar.");
        mainPages.homePage.signIn.click();

        ExtentReportUtils.extentTestInfo("\"Username\"  kutusuna gecerli bir veri girer.");
        mainPages.loginPage.usernameBox.sendKeys(ConfigReader.getProperties("alloverUsername"));

        ExtentReportUtils.extentTestInfo("\"Password\"  kutusuna gecerli bir veri girer.");
        mainPages.loginPage.passwordBox.sendKeys(ConfigReader.getProperties("alloverPassword"));

        ExtentReportUtils.extentTestInfo("\"Sign In\"  butonuna tıklar.");
        mainPages.loginPage.signInButton.click();
        ExtentReportUtils.extentTestPass("Kullanıcı başarıyla giriş yaptı.");

        WaitUtils.waitFor(4);
    }


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
