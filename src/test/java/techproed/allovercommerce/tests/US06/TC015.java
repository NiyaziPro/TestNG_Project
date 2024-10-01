package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC015 extends PreConditionAccessTheWebsite{

    @Test(description = "Kullanıcı Sign In olmadan sepete eklediği ürünlerin miktarını artırabilmeli.")
    public void testIncreaseTheAmountOfProductsToCartWithoutSignIn() {
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        WebElement selectedProduct = mainPages.productPage.selectedProduct(0);

        ActionsUtils.hoverOver(selectedProduct);
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPages.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.viewCartButton);

        int quantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("value"));

        WaitUtils.waitForPageToLoad(10);

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında plus(+) butonuna tıklar.");
        mainPages.cartPage.quantityPlusButton.click();

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        WaitUtils.waitForClickablility(mainPages.cartPage.updateCartButton, 5).click();

        WaitUtils.waitForPageToLoad(10);
        ExtentReportUtils.extentTestInfo("Ürünün miktarının arttığını doğrular.");
        int updateQuantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("value"));

        Assert.assertEquals(updateQuantity, quantity + 1);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını artırabildiği doğrulandı.");
    }
}
