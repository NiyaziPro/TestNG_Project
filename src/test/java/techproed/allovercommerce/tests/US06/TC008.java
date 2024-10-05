package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC008 extends PreConditionAccessTheWebsite{
    @Test(description = "TC008 - Kullanıcı Sign In olmadan da aradığı ürünü sepete ekleyebilmeli (ADD TO CART)")
    public void testProductAddToCartWithoutSignIn() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        WaitUtils.waitFor(5);
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        WebElement selectedProduct = mainPage.shoppingPage.selectedProduct(0);
        ActionsUtils.hoverOverAndWait(selectedProduct,5);
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForVisibility(mainPage.shoppingPage.bagIcon(), 6).click();
        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        WaitUtils.waitForVisibility(mainPage.shoppingPage.hasBeenAddedToCartMsg, 5);
        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        Assert.assertTrue(mainPage.shoppingPage.hasBeenAddedToCartMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının Sign In olmadan aradığı ürünü sepete ekleyebildiği doğrulandı.");


    }
}
