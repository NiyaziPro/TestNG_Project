package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC018 extends PreConditionAccessTheWebsite{

    @Test(description = "TC018 - Kullanıcı Sign In olmadan sepete eklediği ürünlerin miktarını azaltabilmeli")
    public void testReduceTheAmountOfProductsToTheCartWithoutSignIn() {

        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("bag");
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

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında plus(+) butonuna tıklar.");
        mainPage.cartPage.quantityPlusButton().click();

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        mainPage.cartPage.updateCartButton.click();

        WaitUtils.waitFor(3);
        int quantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında minus(-) butonuna tıklar.");
        mainPage.cartPage.quantityMinusButton().click();

        WaitUtils.waitFor(2);
        ExtentReportUtils.extentTestInfo("Ürünün miktarının azaldıgını dogrular.");
        int updateQuantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        Assert.assertEquals(updateQuantity, quantity - 1);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını azaltabildiği doğrulandı.");

    }
}
