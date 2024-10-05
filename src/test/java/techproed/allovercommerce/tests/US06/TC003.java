package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;

public class TC003 extends PreConditionLogged {

    @Test(description = "TC003 - Kullanıcı search box'tan sitede olmayan (alakasız) bir ürünü arattığında ürünün bulunamadıgı mesajı görmeli.")
    public void testSearchIrrelevantProductFromSearchBox() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Sitede olmayan (alakasız) bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("Selenium");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();

        ExtentReportUtils.extentTestInfo("Ürünün bulunamadıgına dagir mesaj gördügünü dogrular.");
        Assert.assertTrue(mainPage.productPage.noProductWereFoundMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının search box'tan sitede olmayan(alakasız) " +
                "bir ürünü arattığında ürünün bulunamadıgı mesajı görüldügü doğrulandı.");

    }
}
