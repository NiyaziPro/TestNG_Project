package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC012 extends PreConditionAccessTheWebsite {
    @Test(description = "TC012 - Kullanıcı Sign In olmadan Sepete (Cart) eklediği ürünleri görebilmeli")
    public void testProductsAddedToTheCartWithoutSignIn() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("Leather shoes");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        WebElement selectedProduct = mainPage.shoppingPage.selectedProduct(0);
        String productText = selectedProduct.getText();
        WaitUtils.waitFor(3);
        ActionsUtils.hoverOverAndWait(selectedProduct,5);
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPage.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.viewCartButton);

        WaitUtils.waitFor(3);

        ExtentReportUtils.extentTestInfo("Ürünü sepette görebildiğini doğrular.");
        Assert.assertTrue(mainPage.cartPage.doesListContainText(productText));
    }
}
