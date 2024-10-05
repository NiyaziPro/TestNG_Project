package techproed.allovercommerce.tests.US06;

import org.testng.annotations.*;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

@Listeners(techproed.utilities.ExtentReportsListener.class)
public class PreConditionLogged {


    @BeforeClass
    public void beforeClass() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.createExtentTest("Pre-condition", "Kullanıcı sisteme giriş yapmış olmalıdır.");
        ExtentReportUtils.setUpExtentReport("TestNG_Project");
        ExtentReportUtils.extentTestInfo("Kullanıcı web sitesine gider.");
        Driver.getDriver().get(ConfigReader.getProperties("allovercommerceUrl"));

        ExtentReportUtils.extentTestInfo("\"Sign In\"  butonuna tıklar.");
        mainPage.homePage.signIn.click();

        ExtentReportUtils.extentTestInfo("\"Username\"  kutusuna gecerli bir veri girer.");
        mainPage.loginPage.usernameBox.sendKeys(ConfigReader.getProperties("alloverUsername"));

        ExtentReportUtils.extentTestInfo("\"Password\"  kutusuna gecerli bir veri girer.");
        mainPage.loginPage.passwordBox.sendKeys(ConfigReader.getProperties("alloverPassword"));

        ExtentReportUtils.extentTestInfo("\"Sign In\"  butonuna tıklar.");
        mainPage.loginPage.signInButton.click();
        ExtentReportUtils.extentTestPass("Kullanıcı başarıyla giriş yaptı.");

        WaitUtils.waitFor(4);
    }

    @AfterClass
    public void afterClass(){
        Driver.closeDriver();
    }

}
