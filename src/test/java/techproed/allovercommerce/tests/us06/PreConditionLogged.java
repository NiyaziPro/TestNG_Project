package techproed.allovercommerce.tests.us06;

import org.testng.annotations.*;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

@Listeners(techproed.utilities.ExtentReportsListener.class)
public class PreConditionLogged {
    MainPages mainPages = new MainPages();

    @BeforeClass
    public void beforeClass() {

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
    public void afterClass(){
        Driver.closeDriver();
    }

}
