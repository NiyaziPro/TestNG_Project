package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC015 extends PreConditionAccessTheWebsite{

    @Test(description = "TC015 - Kullanıcı Sign In olmadan sepete eklediği ürünlerin miktarını artırabilmeli.")
    public void testIncreaseTheAmountOfProductsToCartWithoutSignIn() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        WebElement selectedProduct = mainPage.shoppingPage.selectedProduct(0);

        ActionsUtils.hoverOverAndWait(selectedProduct,5);
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPage.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.viewCartButton);

        ActionsUtils.scrollToElementUsingActions(mainPage.cartPage.updateCartButton);
        int quantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında plus(+) butonuna tıklar.");
        mainPage.cartPage.quantityPlusButton().click();

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        mainPage.cartPage.updateCartButton.click();

        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("Ürünün miktarının arttığını doğrular.");
        int updateQuantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        Assert.assertEquals(updateQuantity, quantity + 1);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını artırabildiği doğrulandı.");
    }
}
