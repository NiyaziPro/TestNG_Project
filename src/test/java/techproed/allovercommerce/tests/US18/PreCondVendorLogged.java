package techproed.allovercommerce.tests.US18;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

@Listeners(techproed.utilities.ExtentReportsListener.class)
 class PreCondVendorLogged {
    MainPage mainPage = new MainPage();

    @BeforeClass
     void beforeClass() {

        ExtentReportUtils.createExtentTest("Pre-condition", "Kullanıcı Vendor olarak sisteme giriş yapmış olmalıdır.");
        ExtentReportUtils.setUpExtentReport("TestNG_Project");
        ExtentReportUtils.extentTestInfo("Kullanıcı web sitesine gider.");
        Driver.getDriver().get(ConfigReader.getProperties("allovercommerceUrl"));

        ExtentReportUtils.extentTestInfo("\"Sign In\"  butonuna tıklar.");
        mainPage.homePage.signIn.click();

        ExtentReportUtils.extentTestInfo("\"Username\"  kutusuna gecerli bir veri girer.");
        mainPage.loginPage.usernameBox.sendKeys(ConfigReader.getProperties("vendorUsername"));

        ExtentReportUtils.extentTestInfo("\"Password\"  kutusuna gecerli bir veri girer.");
        mainPage.loginPage.passwordBox.sendKeys(ConfigReader.getProperties("vendorPassword"));

        ExtentReportUtils.extentTestInfo("\"Sign In\"  butonuna tıklar.");
        mainPage.loginPage.signInButton.click();
        ExtentReportUtils.extentTestPass("Kullanıcı başarıyla giriş yaptı.");

        WaitUtils.waitFor(4);
    }

    @AfterClass
     void afterClass(){
        Driver.closeDriver();
    }

}
