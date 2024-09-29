package techproed.allovercommerce.tests.us06;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;

@Listeners(techproed.utilities.ExtentReportsListener.class)
public class PreConditionAccessTheWebsite {
    MainPages mainPages = new MainPages();

    @BeforeClass
    public void beforeClass() {

        ExtentReportUtils.extentTestInfo("Kullanıcı web sitesine gider.");
        Driver.getDriver().get(ConfigReader.getProperties("allovercommerceUrl"));

    }

    @AfterClass
    public void afterClass() {
        Driver.closeDriver();
    }
}
