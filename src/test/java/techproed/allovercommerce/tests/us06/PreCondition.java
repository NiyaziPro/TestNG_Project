package techproed.allovercommerce.tests.us06;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class PreCondition {
    MainPages mainPages = new MainPages();
    @BeforeClass
    public void dummy() {

        ExtentReportUtils.createExtentTest("Pre-condition", "Kullanıcı sisteme giriş yapmış olmalıdır.");
        ExtentReportUtils.setUpExtentReport("TestNG_Project");
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

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapatıldı.");
    }





}
