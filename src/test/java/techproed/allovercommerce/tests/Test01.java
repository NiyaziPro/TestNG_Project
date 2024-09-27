package techproed.allovercommerce.tests;

import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class Test01 {

    @Test
    public void test01() {
        MainPages mainPages = new MainPages();

        Driver.getDriver().get("https://www.allovercommerce.com/");

        mainPages.homePage.signIn.click();
        mainPages.loginPage.lostYourPasswordLink.click();
    }
}
