package techproed.tests.day18_pageobjectmodel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C03_FirstDriverUsage {

    @Test
    public void test01() {

        Driver.getDriver().get("https://www.youtube.com");
        Driver.getDriver().get("https://www.linkedin.com");
        Driver.getDriver().get("https://www.stackoverflow.com");
        Driver.closeDriver();


    }
}
