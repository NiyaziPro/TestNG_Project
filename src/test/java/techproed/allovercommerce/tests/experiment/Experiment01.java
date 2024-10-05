package techproed.allovercommerce.tests.experiment;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;


public class Experiment01 {

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://www.google.com/");
    }


    @Test
    public void test01() {
        GooglePage googlePage = new GooglePage();
        googlePage.handleCookies();
        googlePage.searchBox.sendKeys("pusula", Keys.ENTER);
        WaitUtils.waitFor(5);
    }

    @Test
    public void test02() {
        GooglePage googlePage = new GooglePage();
        googlePage.handleCookies();
        WaitUtils.waitFor(5);
        googlePage.searchBox.sendKeys("selenium", Keys.ENTER);
        WaitUtils.waitFor(5);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
