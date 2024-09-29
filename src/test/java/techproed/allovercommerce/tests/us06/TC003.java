package techproed.allovercommerce.tests.us06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC003 extends PreConditionLogged {

    @Test(description = "TC003 - Kullanıcı search box'tan sitede olmayan (alakasız) bir ürünü arattığında ürünün bulunamadıgı mesajı görmeli.")
    public void testSearchIrrelevantProductFromSearchBox() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Sitede olmayan (alakasız) bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Selenium");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();

        Assert.assertTrue(mainPages.productPage.noProductWereFoundMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının search box'tan sitede olmayan(alakasız) " +
                "bir ürünü arattığında ürünün bulunamadıgı mesajı görüldügü doğrulandı.");

    }
}
